import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CountdownComponent } from './countdown/countdown.component';
import { CountdownTimerGetSetComponent } from './countdown-timer-get-set/countdown-timer-get-set.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownComponent,
    CountdownTimerGetSetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
