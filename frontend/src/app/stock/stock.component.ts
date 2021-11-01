import { Component, OnInit } from '@angular/core';

import {RestService} from '../services/rest.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  stocks : any[] = [];
  stock = {
    symbol: "",
    name: "",
    currency: "",
    price: 0
  }
  public itemName: string = "";
  public average: number = 0;

  constructor(public rest: RestService) { }

  ngOnInit(): void {
    
  }

  public look(): void{
    this.rest.getProductsByItem(this.itemName).subscribe((data) => {
      this.extractData(data);
      this.insertToStock();
    });
    this.average = 0;
  }

  public refresh(): void{
    var items = "";
    for(var i = 0; i<this.stocks.length ; i++){
      items += ","+this.stocks[i].symbol;
    }
    items = items.substring(1);
    this.rest.getProductsByList(items).subscribe((data) => {
      this.extractListOfData(data, items);
    });
    this.average = 0;
  }

  public delete(symbol: string): void{
    for(var i = 0; i<this.stocks.length ; i++){
      if(this.stocks[i].symbol === symbol){
        this.stocks.splice(i, 1);
      }
    }
    this.average = 0;
  }

  public getAverage(): void{
    this.average = 0;
    var i;
    for(i = 0; i<this.stocks.length ; i++){
      this.average += this.stocks[i].price;
    }
    this.average = this.average / i;
  }

  public changeItemName(event: string){
    this.itemName = event;
  }

  insertToStock(){
    var exist = -1;
    if(this.stock.symbol != ""){
      for(var i = 0; i<this.stocks.length ; i++){
        if(this.stocks[i].symbol === this.stock.symbol){
          exist = i;
        }
      }
      if (exist > -1){
        this.stocks[exist] = this.stock;
      }else{
        this.stocks.push(this.stock);
      }
    }
  }

  private extractData(res: any): any {
    if(res != null){
      if(res.hasOwnProperty("symbol")){
        this.stock = {
          symbol: res.symbol,
          name: "",
          currency: "",
          price: 0
        }
      }
      if(res.hasOwnProperty("name")){
        this.stock.name = res.name
      }
      if(res.hasOwnProperty("currency")){
        this.stock.currency = res.currency
      }
      if(res.hasOwnProperty("quote")){
        if(res.quote.hasOwnProperty("price")){
          this.stock.price = res.quote.price
        }
      }
    }
  }

  private extractListOfData(res: any, items: string){
    var symbolList: string[] = items.split(",");
    if(res != null && res[symbolList[0]] != null){
      this.stocks = [];
      for(var i = 0; i<symbolList.length ; i++){
        this.extractData(res[symbolList[i]]);
        this.insertToStock();
      }
    }
  }

}
