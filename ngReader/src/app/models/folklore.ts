

export class Folklore {
  id: number;
  name: String;
  category: String;
  description: String;
  imageUrl: String;
  location: String;
  lore: String;
  loreUrl: String;


constructor(
  id: number = 0,
  name: String = "",
  category: String = "",
  description: String = "",
  imageUrl: String = "",
  location: String = "",
  lore: String = "",
  loreUrl: String = "",
){
  this.id = id;
  this.name = name ;
  this.category = category;
  this.description = description;
  this.imageUrl = imageUrl;
  this.location = location;
  this.lore = lore;
  this.loreUrl = loreUrl;
}
}
