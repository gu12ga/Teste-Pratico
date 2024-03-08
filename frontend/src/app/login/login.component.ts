import { Component, OnInit, ViewChild } from '@angular/core';
import { trigger, style, animate, transition } from '@angular/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';
import { ApiService } from '../services/api.service';
import { CriptogriaUtil } from '../utils/criptgrafia.util';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    HeaderComponent,
    FooterComponent,
    NgxMaskDirective,
    NgxMaskPipe,
    HttpClientModule
  ],
  providers: [
    provideNgxMask(), CriptogriaUtil
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  animations: [
    trigger('fadeInAnimation', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('1s', style({ opacity: 1 })),
      ]),
    ]),
  ],
})
export class LoginComponent implements OnInit {
  
  constructor(private apiService: ApiService, private cripto: CriptogriaUtil) {}

  ngOnInit(): void {}

  pagina: string = 'Login';

  enviarFormulario(cpf: string, senha: string): void {
    var cpf_cript = this.cripto.encrypt(cpf);

    console.log(cpf_cript);
    
  }
}
