import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {YoutubePlaylistComponent} from '../youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from '../youtube-player/youtube-player.component';

const routes: Routes = [
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [
      {
        path: ':id',
        component: YoutubePlayerComponent
      }
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, {
      preloadingStrategy: PreloadAllModules
    })
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }
