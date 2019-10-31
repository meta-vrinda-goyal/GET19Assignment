import { Injectable } from '@angular/core';
import { Product } from './Product';
import { Cart } from './cart';

@Injectable({
  providedIn: 'root'
})
export class ShoppingSiteService {

  static products:Product[]=[];
  static cart:Cart[]=[];

  constructor() { }

findQuantityInCart(product_id){
  ShoppingSiteService.cart.forEach(cartItem=>function (product_id) {
   if(cartItem.product_id==product_id)
   {
     return cartItem.quantity;
   }
  }); 
  return 0;
}

addToCart(cart){
  ShoppingSiteService.cart.push(cart);
}
}