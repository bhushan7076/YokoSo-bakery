import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [ReactiveFormsModule, CommonModule]
})
export class LoginComponent {
  loginForm: FormGroup;
  signupForm: FormGroup;
  isFlipped = false;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.loginForm = this.fb.group({
      custUsername: ['', Validators.required],
      custPassword: ['', Validators.required]
    });

    this.signupForm = this.fb.group({
      custName: ['', Validators.required],
      custEmail: ['', [Validators.required, Validators.email]],
      custMobile: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      custUsername: ['', Validators.required],
      custPassword: ['', Validators.required]
    });
  }

  toggleCard(event?: Event): void {
    if (event) event.preventDefault();
    this.isFlipped = !this.isFlipped;
  }

  onLogin(): void {
    if (this.loginForm.valid) {
      this.http.post<any>('http://localhost:8080/customer/signin', this.loginForm.value).subscribe({
        next: (res) => {
          alert(res.message);
          localStorage.setItem('customerId', res.customerId);
          this.router.navigateByUrl('/home');
        },
        error: (err) => {
          alert(err.error.error);
        }
      });
    } else {
      this.loginForm.markAllAsTouched();
      alert('Please fill all required fields.');
    }
  }

  onSignup(): void {
    if (this.signupForm.valid) {
      this.http.post<any>('http://localhost:8080/customer/signup', this.signupForm.value).subscribe({
        next: (res) => {
          alert('Signup successful!');
          this.toggleCard();
        },
        error: (err) => {
          alert(err.error.error || 'Something went wrong!');
        }
      });
    } else {
      this.signupForm.markAllAsTouched();
      alert('Please fill all required fields correctly.');
    }
  }
}
