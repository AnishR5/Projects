//lib
const express=require("express")
const app=express();
const bodyparser=require("body-parser")
const routes=require("./router/routers")
const cors=require("cors")

app.use(cors({
    origin:"http://localhost:3000",
    credentials:true
}))

//middleware
app.use(bodyparser.urlencoded({extended:false}))
app.use(bodyparser.json())
//config
// app.use(function(req, res, next) {
//     res.setHeader('Access-Control-Allow-Origin', '*');
//     res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
//     res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
//     res.setHeader('Access-Control-Allow-Credentials', true);
//     next();
// });

//urlhandler
app.use("/",routes)

app.listen(3002,()=>{
    console.log("server started on port 3002")
})