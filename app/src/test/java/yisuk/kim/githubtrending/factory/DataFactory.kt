package yisuk.kim.githubtrending.factory

import java.util.concurrent.ThreadLocalRandom

/**
 * @author <a href="kimls125@gmail.com">Yisuk Kim</a> on 03-06-2018.
 */
class DataFactory {

    companion object Factory {

        fun randomInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
        }

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }
    }
}