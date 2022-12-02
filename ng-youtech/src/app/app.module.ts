import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  ConfirmBoxConfigModule,
  DialogConfigModule,
  NgxAwesomePopupModule,
  ToastNotificationConfigModule,
} from '@costlydeveloper/ngx-awesome-popup';
import { NgxUiLoaderModule } from 'ngx-ui-loader';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContainerModule } from './commons/components/container/container.module';
import { HomePageModule } from './pages/home-page/home-page.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ContainerModule,
    HomePageModule,
    HttpClientModule,
    NgxUiLoaderModule,
    NgxAwesomePopupModule.forRoot(), // Essential, mandatory main module.
    DialogConfigModule.forRoot(), // Needed for instantiating dynamic components.
    ConfirmBoxConfigModule.forRoot(), // Needed for instantiating confirm boxes.
    ToastNotificationConfigModule.forRoot(), // Needed for instantiating toast notifications.
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
