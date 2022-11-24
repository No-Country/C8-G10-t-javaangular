import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-flow',
  templateUrl: './login-flow.component.html',
  styleUrls: ['./login-flow.component.scss'],
})
export class LoginFlowComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
  dmeo(): void {
    console.log('---');
  }
}
