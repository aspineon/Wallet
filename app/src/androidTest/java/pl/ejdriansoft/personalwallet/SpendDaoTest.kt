package pl.ejdriansoft.personalwallet

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import pl.ejdriansoft.personalwallet.data.SpendEntity
import pl.ejdriansoft.personalwallet.data.TagEntity
import pl.ejdriansoft.personalwallet.data.TagMapEntity
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.db.TagDao
import pl.ejdriansoft.personalwallet.db.TagMapDao


@RunWith(AndroidJUnit4::class)
class SpendDaoTest {

    private lateinit var db: SpendDatabase
    private lateinit var spendDao: SpendDao
    private lateinit var tagDao: TagDao
    private lateinit var tagMapDao: TagMapDao

    @Before
    fun initDependencies() {
        val context = ApplicationProvider.getApplicationContext<Application>()

        db = Room.inMemoryDatabaseBuilder(context, SpendDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        spendDao = db.spendDao()
        tagDao = db.tagDao()
        tagMapDao = db.tagMapDao()
    }

    @After
    fun close() {
        db.close()
    }

    @Test
    fun testSaveAndGetAll() {
        val spend = SpendEntity(comment = "comment", name = "name", price = 18.0)

        spendDao.insert(spend)

        val requestedEntities = spendDao.getAll()

        Assert.assertEquals(spend.comment, requestedEntities.first().comment)
        Assert.assertEquals(spend.date, requestedEntities.first().date)
        Assert.assertEquals(spend.id, requestedEntities.first().id)
    }

    @Test
    fun testSaveMultiply() {
        val spend = SpendEntity(comment = "comment", name = "name", price = 18.0)
        val spend1 = SpendEntity(comment = "comment", name = "name", price = 16.0)
        val spend2 = SpendEntity(comment = "comment", name = "name", price = 18.0)
        val list = listOf(spend, spend1, spend2)
        db.spendDao().insert(list)

        val requestedEntities = spendDao.getAll()
        Assert.assertEquals(list.size, requestedEntities.size)
        Assert.assertEquals(list[1].price.toFloat(), requestedEntities[1].price.toFloat())
    }

    @Test
    fun testAddObjectTwiceIgnore() {
        val spend = SpendEntity(comment = "comment", name = "name", price = 18.0)
        val list = listOf(spend, spend)

        spendDao.insert(list)

        val requestedEntities = spendDao.getAll()

        Assert.assertEquals(1, requestedEntities.size)
    }

    @Test
    fun testGetAllByTagName() {
        val spendApple = SpendEntity(comment = "apple", name = "apple", price = 14.0)
        val spendBlueBerry = SpendEntity(comment = "blueberry", name = "blueberry", price = 16.0)
        val spendBills = SpendEntity(comment = "bills", name = "bills", price = 18.0)
        val tagFood = TagEntity(name = "food")
        val tagBills = TagEntity(name = "bills")

        spendDao.insert(listOf(spendApple, spendBlueBerry, spendBills))
        tagDao.insert(listOf(tagFood, tagBills))

        val spends = spendDao.getAll()
        val tags = tagDao.getAll()

        val tagMapApple = TagMapEntity(spends[0].id, tags[0].id)
        val tagMapBill = TagMapEntity(spends[2].id, tags[1].id)
        val tagMapBlueBerry = TagMapEntity(spends[1].id, tags[0].id)

        tagMapDao.addAssignedTag(listOf(tagMapApple, tagMapBill, tagMapBlueBerry))

        val allFoodsSpends = spendDao.getAllByTagName(tagFood.name)
        val allBillsSpends = spendDao.getAllByTagName(tagBills.name)

        Assert.assertEquals(2, allFoodsSpends.size)
        Assert.assertEquals(1, allBillsSpends.size)
    }

}