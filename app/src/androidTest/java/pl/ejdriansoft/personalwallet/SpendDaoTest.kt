package pl.ejdriansoft.personalwallet

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import pl.ejdriansoft.personalwallet.data.SpendEntity
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.db.SpendDatabase_Impl
import pl.ejdriansoft.personalwallet.di.roomTestModule


@RunWith(AndroidJUnit4::class)
class SpendDaoTest : AutoCloseKoinTest() {

    val db by inject<SpendDatabase>()
    val dao by inject<SpendDao>()

    @BeforeEach
    fun initDependencies() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        loadKoinModules(roomTestModule)

//        db = Room.inMemoryDatabaseBuilder(context, SpendDatabase::class.java)
//            .allowMainThreadQueries()
//            .build()
//        dao = db.spendDao()
    }

    @After
    fun close() {
        db.close()
    }

    @Test
    fun testSaveAndGetAll() {
        val spend = SpendEntity(comment = "comment", category = 1)

        dao.insert(spend)

        val requestedEntities = dao.getAll()

        Assert.assertEquals(spend.category, requestedEntities.first().category)
        Assert.assertEquals(spend.comment, requestedEntities.first().comment)
        Assert.assertEquals(spend.date, requestedEntities.first().date)
        Assert.assertEquals(spend.id, requestedEntities.first().id)
    }

    @Test
    fun testSaveMultiply() {
        val spend = SpendEntity(comment = "comment", category = 1)
        val spend1 = SpendEntity(comment = "comment", category = 1)
        val spend2 = SpendEntity(comment = "comment", category = 1)
        val list = listOf(spend, spend1, spend2)
        list.forEach {
            db.spendDao().insert(it)
        }

        val requestedEntities = dao.getAll()
        Assert.assertEquals(list.size, requestedEntities.size)
    }

    @Test(expected = SQLiteConstraintException::class)
    fun addObjectTwiceException() {
        val spend = SpendEntity(comment = "comment", category = 1)
        val list = listOf(spend, spend)

        list.forEach {
            db.spendDao().insert(it)
        }
    }

}