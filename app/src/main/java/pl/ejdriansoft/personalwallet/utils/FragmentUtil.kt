package pl.ejdriansoft.personalwallet.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.IntDef
import androidx.fragment.app.Fragment
import pl.ejdriansoft.personalwallet.R


object FragmentUtils {

    const val TRANSITION_POP = 0
    const val TRANSITION_FADE_IN_OUT = 1

    @IntDef(
        TRANSITION_POP,
        TRANSITION_FADE_IN_OUT
    )
    internal annotation class FragmentAnimation


    fun replaceFragment(
        activity: AppCompatActivity?,
        fragment: Fragment,
        id: Int,
        addToBackStack: Boolean = true,
        @FragmentAnimation animationType: Int = TRANSITION_POP
    ) {
        if (null == activity)
            return

        val fragmentManager = activity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        when (animationType) {
            TRANSITION_POP -> transaction.setCustomAnimations(
                R.anim.anim_enter,
                R.anim.anim_exit,
                R.anim.anim_pop_enter,
                R.anim.anim_pop_exit
            )
            TRANSITION_FADE_IN_OUT -> transaction.setCustomAnimations(
                R.anim.anim_frag_fade_in,
                R.anim.anim_frag_fade_out
            )
            else -> transaction.setCustomAnimations(0, 0)
        }

        if (addToBackStack)
            transaction.addToBackStack(fragment.javaClass.canonicalName)

        transaction.replace(id, fragment, fragment.javaClass.canonicalName)
        transaction.commit()
    }
}