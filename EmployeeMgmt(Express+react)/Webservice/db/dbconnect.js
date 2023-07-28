const mysql=require("mysql")

//create connection
const mysqlconnection=mysql.createConnection({
    host:"127.0.0.1",
    user:"root",
    password:"admin@123",
    port:3306,
    database:"wpt"
})

//connect

mysqlconnection.connect((err)=>{
    if(err)
    {
        console.log("db connection failed")
    }
    else
    console.log("Db connected")
})

module.exports=mysqlconnection;