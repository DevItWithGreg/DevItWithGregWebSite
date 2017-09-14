import {Thumbnail} from './thumbnail.model';
import {SafeResourceUrl} from '@angular/platform-browser';

export class Video {
    public title?: string;
    public videoId?: string;
    public url?: SafeResourceUrl;
    public thumbnail?: Thumbnail;
    public displayFrame?: Boolean;

    constructor(title?: string,
                videoId?: string,
                thumbnail?: Thumbnail,
                displayFrame?: Boolean) {
        this.title = title;
        this.videoId = videoId;
        this.url = null;
        this.thumbnail = thumbnail;
        this.displayFrame = displayFrame;
    }
}
