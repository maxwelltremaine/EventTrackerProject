

export class Folklore {
  id: number;
  name: String;
  category: String;
  description: String;
  lore: String;
  loreUrl: String;


constructor(
  id: number = 0,
  name: String = "",
  category: String = "",
  description: String = "",
  lore: String = "",
  loreUrl: String = "",
){
  this.id = id;
  this.name = name ;
  this.category = category;
  this.description = description;
  this.lore = lore;
  this.loreUrl = loreUrl;
}
}
