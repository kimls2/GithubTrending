package yisuk.kim.githubtrending.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Entity(
        tableName = "github_repo",
        indices = [
            (Index(value = ["githubId"], unique = true))
        ]
)
data class GithubRepo(
        @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "githubId") var id: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "htmlUrl") val htmlUrl: String,
        @ColumnInfo(name = "starCount") val starCount: Int,
        @ColumnInfo(name = "login") val login: String,
        @ColumnInfo(name = "avatarUrl") val avatarUrl: String
)