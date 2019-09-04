package pl.ejdriansoft.personalwallet

import androidx.arch.core.executor.TaskExecutor
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTest
import org.koin.test.inject
import pl.ejdriansoft.personalwallet.data.SpendEntity
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.di.roomTestModule
import pl.ejdriansoft.personalwallet.di.testContext
import java.util.*

@RunWith(AndroidJUnit4::class)
class SpendDaoTest : AutoCloseKoinTest() {

    val spendDao by inject<SpendDao>()

    @Before
    fun initDependencies() {
        loadKoinModules(roomTestModule)
    }

    @Test
    fun testSave() {
        val now = Date()

        val spend = SpendEntity("comment", 1, now)

        spendDao.insert(spend)

        val requestedEntities = spendDao.getAll()

        Assert.assertEquals(spend.category, requestedEntities.first().category)
        Assert.assertEquals(spend.comment, requestedEntities.first().comment)
        Assert.assertEquals(spend.date, requestedEntities.first().date)
        Assert.assertEquals(spend.id, requestedEntities.first().id)
    }
}