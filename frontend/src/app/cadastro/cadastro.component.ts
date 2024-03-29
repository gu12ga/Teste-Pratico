import { Component, OnInit } from '@angular/core';
import { trigger, style, animate, transition } from '@angular/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';
import { ApiService } from '../services/api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastro',
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
    CommonModule
  ],
  providers: [
    provideNgxMask(),
  ],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css',
  animations: [
    trigger('fadeInAnimation', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('1s', style({ opacity: 1 })),
      ]),
    ]),
  ],
})
export class CadastroComponent implements OnInit {
  constructor(private apiService: ApiService) {}

  pagina: string = 'Cadastro Pacientes';
  UFs: string[] = [];

  ngOnInit(): void {
    this.apiService.getUFs().subscribe((data) => {
      this.UFs = data;
      console.log(this.UFs);
    },
    (error) => {
      console.error('Erro na solicitação HTTP:', error);
    }
    );
  }
}