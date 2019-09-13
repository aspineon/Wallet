package pl.ejdriansoft.personalwallet

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import pl.ejdriansoft.personalwallet.data.SpendEntity
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.SpendDatabase


@RunWith(AndroidJUnit4::class)
class SpendDaoTest {

    lateinit var db: SpendDatabase
    lateinit var dao: SpendDao

    @Before
    fun initDependencies() {
        val context = ApplicationProvider.getApplicationContext<Application>()

        db = Room.inMemoryDatabaseBuilder(context, SpendDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.spendDao()
    }

    @After
    fun close() {
        db.close()
    }

    @Test
    fun testSaveAndGetAll() {
        val spend = SpendEntity(comment = "comment", name = "name", price = 18.0)

        dao.insert(spend)

        val requestedEntities = dao.getAll()

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
        list.forEach {
            db.spendDao().insert(it)
        }

        val requestedEntities = dao.getAll()
        Assert.assertEquals(list.size, requestedEntities.size)
        Assert.assertEquals(list[1].price.toFloat(), requestedEntities[1].price.toFloat())
    }

    @Test(expected = SQLiteConstraintException::class)
    fun addObjectTwiceException() {
        val spend = SpendEntity(comment = "comment", name = "name", price = 18.0)
        val list = listOf(spend, spend)

        list.forEach {
            db.spendDao().insert(it)
        }
    }

}