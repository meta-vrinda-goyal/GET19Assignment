import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../Product';
import { ShoppingSiteService } from '../shopping-site.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 
  private products:Product[]=[];
  constructor(private http:HttpClient,private service:ShoppingSiteService) { 
    let obs=this.http.get<Product[]>('http://localhost:8080/UI-Session-11/rest/home')
    .subscribe((response)=>response.forEach(product => {
      this.products.push(product)}));
      ShoppingSiteService.products=this.products;
  }

  ngOnInit() {
  }
  findQuantityInCart(product_id){
    this.service.findQuantityInCart(product_id);
  }
  addToCart(product_id){
    this.service.addToCart(product_id);
  }
}
