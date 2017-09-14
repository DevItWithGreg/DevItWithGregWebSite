import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Playlist} from '../../entities/youtube/playlist.model';

@Injectable()
export class YoutubeService {
    private playlistUrl = 'youtube/playlist';

    constructor(private http: Http) {
    }

    find(): Observable<Playlist[]> {
        console.log('do the request');
        return this.http.get(this.playlistUrl)
            .map((res: Response) => res.json());
    }

}
