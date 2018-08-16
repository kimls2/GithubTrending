package yisuk.kim.githubtrending.home

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoActivityResumedException
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.view.View
import junit.framework.TestCase
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import yisuk.kim.githubtrending.R
import yisuk.kim.githubtrending.util.clickChildViewWithId

/**
 * @author [Yisuk Kim](yisuk@mobilabsolutions.com) on 16-08-2018.
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityNavigationTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun clickOnRecyclerViewItem_ShowsDetailScreen() {
        Thread.sleep(1000)
        clickOnRecyclerViewChildItemAtPosition(R.id.rv_repos, 0, R.id.view_repo_item)

        Thread.sleep(1000)
        onView(withId(R.id.detail_toolbar)).check(matches(isDisplayed()))
        onView(withText(getResourceString(R.string.detail_title))).check(matches(withParent(withId(R.id.detail_toolbar))))
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
    }

    @Test
    fun detailScreen_backButtonTest() {
        Thread.sleep(1000)
        clickOnRecyclerViewChildItemAtPosition(R.id.rv_repos, 0, R.id.view_repo_item)

        Thread.sleep(1000)
        Espresso.pressBack()
        Thread.sleep(1000)
        onView(withId(R.id.repos_toolbar)).check(ViewAssertions.matches(isDisplayed()))
        onView(withText(getResourceString(R.string.repos_title))).check(ViewAssertions.matches(withParent(withId(R.id.repos_toolbar))))
    }

    @Test
    fun backFromHomeScreen_ExitsApp() {
        try {
            Espresso.pressBack()
            TestCase.fail("Should kill the app and throw an exception")
        } catch (e: NoActivityResumedException) {
            // Test OK
        }
    }

    private fun clickOnRecyclerViewChildItemAtPosition(recyclerViewId: Int, position: Int, childViewId: Int) {
        onView(CoreMatchers.allOf<View>(isDisplayed(), withId(recyclerViewId)))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, clickChildViewWithId(childViewId)))
    }

    private fun getResourceString(id: Int): String {
        val targetContext = InstrumentationRegistry.getTargetContext()
        return targetContext.resources.getString(id)
    }
}