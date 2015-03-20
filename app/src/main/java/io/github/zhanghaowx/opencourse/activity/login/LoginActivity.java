package io.github.zhanghaowx.opencourse.activity.login;

import android.support.v4.app.Fragment;

import io.github.zhanghaowx.opencourse.R;
import io.github.zhanghaowx.opencourse.activity.core.BaseActivity;
import io.github.zhanghaowx.opencourse.fragment.login.LoginFragment;

/**
 * Created by hao on 3/19/15.
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected Fragment getFragment() {
        return new LoginFragment();
    }

    @Override
    protected int getFragmentId() {
        return R.id.activity_default_content_container;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_default;
    }

    @Override
    protected int getToolbarId() {
        return 0;
    }
}
