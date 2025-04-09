import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-order',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './order.component.html',
  styleUrl: './order.component.css'
})
export class OrderComponent implements OnInit {
  orders: any[] = [];
  apiUrl: string = 'http://localhost:8080/api/orders/customer';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    const storedCustomer = localStorage.getItem('customerId');
    const customerId = storedCustomer ? +storedCustomer : null;

    if (customerId) {
      this.fetchOrdersByCustomerId(customerId);
    } else {
      console.warn('Customer ID not found in localStorage.');
    }
  }

  fetchOrdersByCustomerId(custId: number) {
    this.http.get<any[]>(`${this.apiUrl}/${custId}`).subscribe({
      next: (data) => {
        this.orders = data;
      },
      error: (err) => {
        console.error('Error fetching orders:', err);
      }
    });
  }

  formatDate(date: string): string {
    const d = new Date(date);
    return d.toLocaleDateString() + ' ' + d.toLocaleTimeString();
  }

  getGrandTotal(): number {
    return this.orders.reduce((sum, item) => sum + item.total, 0);
  }

  onDone(): void {
    alert("Thank you for your order!");
    // Optional: Navigate to another page or clear cart/orders
  }
}
