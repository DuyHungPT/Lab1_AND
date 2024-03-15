const express = require('express')
const app = express()
const port = 3000

app.listen(port, ()=> {
  console.log(`server dang chay tren cong ${port}`);
})

const uri = 'mongodb+srv://hungbdph43753:Ilx3WXBBfFqzVgR9@cluster0.6euxn2v.mongodb.net/MyData';

const spModel = require('./sanphamModel');
const mongoose = require('mongoose');
const sanphamModel = require('./sanphamModel');

app.get('/',async (req,res)=> {
  await mongoose.connect(uri);

  let sanphams = await spModel.find();
  console.log(sanphams);
  res.send(sanphams);
})

app.get('/add_sp', async (req,res)=>{
  await mongoose.connect(uri);

  let sanpham = {
    ten : 'San Pham 3',
    gia : 800,
    soluong : 5,
    tonkho : true
  }
  let kq = await spModel.create(sanpham);
  console.log(kq);
  let sanphams = await spModel.find();
  res.send(sanphams);
})  

app.get('/xoa/:id', async(req,res)=> {

  await mongoose.connect(uri); 
  let id = req.params.id;
  let kq = await spModel.deleteOne({_id: id});
  
 console.log(kq);

})

app.get('/update/:ten', async(req,res)=> {
  await mongoose.connect(uri); 

  console.log('ket noi db');
  let ten = req.params.ten;

  let tenSPNew = ten  + 'new pro duct';

  await sanphamModel.updateOne({ten : ten},{ten : tenSPNew});

  let sanphams = await sanphamModel.find({});
  res.send(sanphams);

})