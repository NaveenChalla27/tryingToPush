export class ItemsList {
    id:number;
    itemname:string;
    itemprice:number;
    quantity:number;
    image:string;
    constructor(id:number,itemprice:number,qunatity:number,image:string,itemname:string){
        this.id=id;
        this.itemprice=itemprice;
        this.image=image;
        this.quantity=qunatity;
        this.itemname=itemname;

    }
}
