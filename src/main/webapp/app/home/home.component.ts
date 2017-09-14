import {Component, OnInit} from '@angular/core';
import {NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {JhiEventManager} from 'ng-jhipster';

import {Account, LoginModalService, Principal} from '../shared';
import {YoutubeService} from '../shared/youtube/youtube.service'
import {Playlist} from '../entities/youtube/playlist.model';
import {Video} from '../entities/youtube/video.model';

import {DomSanitizer} from '@angular/platform-browser';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: [
        'home.css'
    ]

})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    playlist: Playlist[];

    constructor(private youtubeService: YoutubeService,
                private sanitizer: DomSanitizer,
                private principal: Principal,
                private loginModalService: LoginModalService,
                private eventManager: JhiEventManager) {
    }

    ngOnInit() {
        this.principal.identity().then((account) => {
            this.account = account;
        });

        this.registerAuthenticationSuccess();
        this.youtubeService.find()
            .subscribe((response) => {
                if (response) {
                    this.playlist = response;
                    // FIXME find a better way of build embedded url
                    this.playlist.forEach((playlistItem) => {
                        playlistItem.videos.forEach((video) => {
                            video.url = this.sanitizer.bypassSecurityTrustResourceUrl('http://www.youtube.com/embed/' + video.videoId + '?autoplay=1');
                        });
                    });
                }
            });
    }

    displayVideo(currentVideo: Video) {
        this.playlist.forEach((playlistItem) => {
            playlistItem.videos.forEach((video) => {
                video.displayFrame = video.videoId === currentVideo.videoId;
            });
        });
    }

    collapseSection(id: string) {
        const ref = document.getElementById(id);
        if (ref.classList.contains('collapse') && ref.classList.contains('show')  ) {
            ref.classList.remove('show');
        } else {
            ref.classList.add('show');
        }
        this.displayVideo(new Video());
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            this.principal.identity().then((account) => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }
}
