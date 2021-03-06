package io.realm.dagger1.example.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.dagger1.example.MainActivity;
import io.realm.dagger1.example.networks.TwitterApi;
import io.realm.dagger1.example.twitters.Timeline;
import io.realm.dagger1.example.twitters.Tweeter;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
@Module(
        library = true,
        injects = {
                MainActivity.class
        }
)
public class TwitterModule {

    private final String username;

    public TwitterModule(String username) {
        this.username = username;
    }

    @Provides
    @Singleton
    Tweeter provideTwitter(TwitterApi twitterApi) {
        return new Tweeter(twitterApi, username);
    }

    @Provides
    @Singleton
    Timeline provideTimeline(TwitterApi twitterApi) {
        return new Timeline(twitterApi, username);
    }
}
