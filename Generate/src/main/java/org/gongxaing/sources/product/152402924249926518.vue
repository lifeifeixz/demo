<html>
 <head></head> 
 <body> 
  <template> 
   <div> 
    <el-form :inline="true" :model="queryParams" class="demo-form-inline">    
     <el-form-item id="queryBtn"> 
      <el-button type="primary" size="small" @click="queryList">
        查询 
      </el-button> 
      <el-button size="small" @click="initForm">
        重置 
      </el-button> 
     </el-form-item> 
    </el-form> 
    <el-table :data="tableData" v-loading="listLoading" class="table" empty-text="暂无数据" border fit stripe highlight-current-row style="width: 100%" header-row-class-name="carMgrTable"> 
     <el-table-column type="index" label="序号" class="first" width="50" align="center"></el-table-column>  
     <el-table-column property="id" align="center" class="td-template" label="车辆牌号"></el-table-column>
     <el-table-column property="id" align="center" class="td-template" label="所属地"></el-table-column>
     <el-table-column property="id" align="center" class="td-template" label="车辆型号"></el-table-column>
     <el-table-column property="id" align="center" class="td-template" label="车辆归属"></el-table-column>
     <el-table-column property="id" align="center" class="td-template" label="年检有效期"></el-table-column>
     <el-table-column property="id" align="center" class="td-template" label="当前位置"></el-table-column>
     <el-table-column property="id" align="center" class="td-template" label="车辆营运状态"></el-table-column>
     <el-table-column align="left" class="operation" width="300" label="操作"> 
      <template slot-scope="scope"> 
       <el-button size="mini" @click="goto({path: './rentCarEdit',query:{id:scope.row.id,type:'info'}})">
         详情 
       </el-button> 
       <el-button type="primary" size="mini" @click="goto({path: './rentCarEdit',query:{id:scope.row.id,type:'edit'}})">
         编辑 
       </el-button> 
      </template> 
     </el-table-column> 
    </el-table> 
    <div v-show="!listLoading" class="block" style="text-algin:center"> 
     <el-pagination @size-change="pageSizeChange" @current-change="pageCurrentChange" :current-page.sync="queryParams.page" :page-sizes="queryParams.pageSizes" :page-size="queryParams.size" layout="total, sizes, prev, pager, next, jumper" :total="total"> 
     </el-pagination> 
    </div> 
   </div> 
  </template>  
 </body>
</html>