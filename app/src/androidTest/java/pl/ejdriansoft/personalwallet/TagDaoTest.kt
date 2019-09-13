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
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.db.TagDao


@RunWith(AndroidJUnit4::class)
class TagDaoTest {

    lateinit var db: SpendDatabase
    lateinit var dao: TagDao

    @Before
    fun initDependencies() {
        val context = ApplicationProvider.getApplicationContext<Application>()

        db = Room.inMemoryDatabaseBuilder(context, SpendDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.tagDao()
    }

    @After
    fun close() {
        db.close()
    }

    @Test
    fun testSaveAndGetAll() {
        val tag = TagEntity(name = "name")

        dao.insert(tag)

        val requestedEntities = dao.getAll()

        Assert.assertEquals(tag.name, requestedEntities.first().name)
        Assert.assertEquals(tag.id, requestedEntities.first().id)
    }

    @Test
    fun testSaveMultiply() {
        val tag = TagEntity(name = "name")
        val tag1 = TagEntity(name = "name")
        val tag2 = TagEntity(name = "name")

        val list = listOf(tag, tag1, tag2)
        dao.insert(list)

        val requestedEntities = dao.getAll()
        Assert.assertEquals(list.size, requestedEntities.size)
    }

    @Test
    fun testAddObjectTwiceIgnore() {
        val tag = TagEntity(name = "name")
        val list = listOf(tag, tag)

        dao.insert(list)
        val requestedEntities = dao.getAll()

        Assert.assertEquals(1, requestedEntities.size)
    }

}