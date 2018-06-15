<html>
 <head></head> 
 <body> 
  <el-row class="detail-rows" v-loading="loading"> 
   <!-- 返回上一页 --> 
   <el-row :span="4" :offset="20" style="text-align: right;"> 
    <el-button size="small" @click="goto('poolComplainRecord',{})" type="primary">
      返回上一页 
    </el-button> 
   </el-row> 
   <!-- 正文 --> 
   <el-row :gutter="24" class="row">  
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       车辆牌号 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       所属地 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       车辆型号 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       车辆归属 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       年检有效期 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       当前位置 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
    <el-col :span="8" class="item"> 
     <el-col :span="8" class="detail-lab">
       车辆营运状态 
     </el-col> 
     <el-col :span="16" class="detail-value">
       &nbsp;{{obj.id}} 
     </el-col> 
    </el-col>
   </el-row> 
  </el-row> 
  <style>

    .detail-lab, .detail-val {
        display: block;
        float: left;
    }

    .detail-lab {
        font-weight: 600;
        text-align: right;
    }

    .detail-val {
        width: 70%;
    }

    .detail-rows {
        background: #fff;
        padding: 10px;
        border-radius: 5px;
    }

</style>  
 </body>
</html>