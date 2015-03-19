package io.github.zhanghaowx.opencourse.activity.course;

import android.support.v4.app.Fragment;

import io.github.zhanghaowx.opencourse.R;
import io.github.zhanghaowx.opencourse.activity.core.NavigationDrawerActivity;
import io.github.zhanghaowx.opencourse.fragment.course.CourseListHomeFragment;

/**
 * For course list activity
 */
public class CourseListActivity extends NavigationDrawerActivity {

    @Override
    protected Fragment getFragment() {
        return new CourseListHomeFragment();
    }

    @Override
    protected int getFragmentId() {
        return R.id.activity_with_drawer_menu_content_container;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_with_drawer_menu;
    }

    @Override
    protected int getToolbarId() {
        return R.id.activity_with_drawer_menu_toolbar;
    }

    @Override
    protected int getEnterTransition() {
        return R.transition.default_transition;
    }

    @Override
    protected int getExitTransition() {
        return R.transition.default_transition;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.course_list_actionbar_title;
    }

}
