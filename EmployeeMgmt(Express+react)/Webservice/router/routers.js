const express=require("express")
const router=express.Router()
const connection=require("../db/dbconnect")

router.get("/employees",(req,resp)=>{
    connection.query("select * from employee",(err,data)=>{
        if(err)
        {
            resp.status(500).send("data not found "+ JSON.stringify(err))
        }
        else{
            resp.send(data)
        }
    })
})

router.post("/addEmp",(req,resp)=>{
    var empid=req.body.empid ;
    var ename=req.body.ename ;
    var sal=req.body.sal;
    connection.query("insert into employee values (?,?,?)",[empid,ename,sal],(err,data)=>{
        if(err)
            resp.status(500).send("data not inserted "+ JSON.stringify(err))
        else
        resp.send("success")
    })
})

router.delete("/delEmp/:empid",(req,resp)=>{
    connection.query("delete from employee where empid=?",[req.params.empid],(err,data)=>{
        if(err)
            resp.status(500).send("data not deleted "+ JSON.stringify(err))
        else
        resp.send("success")
    })
})

router.put("/updateEmp/:empid",(req,resp)=>{
    var empid=req.body.empid 
    var ename=req.body.ename;
    var sal=req.body.sal ; 
    connection.query("update employee set ename=?,sal=? where empid=?",[ename,sal,empid],(err,data)=>{
        if(err)
            resp.status(500).send("data not updated "+ JSON.stringify(err))
        else
        resp.send("success")
    })
})

module.exports=router;