package yisuk.kim.githubtrending.commons

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
@BindingAdapter("android:avatarUrl")
fun setAvatarImage(view: ImageView, avatarUrl: String) {
    GlideApp.with(view).load(avatarUrl).centerCrop().into(view)
}