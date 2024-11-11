<template>
	<div class="main-content" :style='{"padding":"30px 0 0"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"150px","margin":"0","position":"absolute","right":"7%","background":"none","zIndex":"1003"}' :inline="true" :model="searchForm">
				<el-row :style='{"flexWrap":"wrap","justifyContent":"center","display":"flex"}' >
					<div :style='{"width":"100%","margin":"0 0 10px","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
						<label :style='{"margin":"0","color":"#333","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">电桩编号</label>
						<el-input v-model="searchForm.dianzhuangbianhao" placeholder="电桩编号" clearable></el-input>
					</div>
					<div :style='{"width":"100%","margin":"0 0 10px","flexWrap":"wrap","justifyContent":"center","display":"flex"}' class="select" label="电桩状态" prop="dianzhuangzhuangtai">
						<label :style='{"margin":"0","color":"#333","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">电桩状态</label>
						<el-select  @change="dianzhuangzhuangtaiChange" clearable v-model="searchForm.dianzhuangzhuangtai" placeholder="请选择电桩状态">
							<el-option v-for="(item,index) in dianzhuangzhuangtaiOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"width":"100%","margin":"0 0 10px","flexWrap":"wrap","justifyContent":"center","display":"flex"}' class="select" label="电桩分类" prop="dianzhuangfenlei">
						<label :style='{"margin":"0","color":"#333","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">电桩分类</label>
						<el-select  @change="dianzhuangfenleiChange" clearable v-model="searchForm.dianzhuangfenlei" placeholder="请选择电桩分类">
							<el-option v-for="(item,index) in dianzhuangfenleiOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"width":"100%","margin":"0 0 10px","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
						<label :style='{"margin":"0","color":"#333","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">小时单价</label>
						<el-input v-model="searchForm.xiaoshidanjiastart" placeholder="最小小时单价" clearable></el-input>
					</div>
					<div :style='{"width":"100%","margin":"0 0 10px","flexWrap":"wrap","justifyContent":"center","display":"flex"}' :label="'至'">
						<el-input v-model="searchForm.xiaoshidanjiaend" placeholder="最大小时单价" clearable></el-input>
					</div>
					<div :style='{"width":"100%","margin":"0 0 10px","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
						<label :style='{"margin":"0","color":"#333","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">位置</label>
						<el-input v-model="searchForm.weizhi" placeholder="位置" clearable></el-input>
					</div>
					<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0px","outline":"none","backgroundColor":"#fff","margin":"10px auto","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"100%","fontSize":"14px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"margin":"20px 0 0 0px","flexWrap":"wrap","flexDirection":"column","background":"none","justifyContent":"center","display":"flex"}'>
					<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0 24px","margin":"0 auto 10px","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"100%","fontSize":"14px","height":"40px"}' v-if="isAuth('chongdianzhuang','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0 24px","margin":"0 auto 10px","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"100%","fontSize":"14px","height":"40px"}' v-if="isAuth('chongdianzhuang','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","margin":"0 0 0 7%","borderRadius":"30px 30px 5px 5px","borderWidth":"1px 0 0 1px","background":"#fff","width":"calc(86% - 170px)","borderStyle":"solid"}' 
					v-if="isAuth('chongdianzhuang','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'  
						prop="dianzhuangbianhao"
					label="电桩编号">
						<template slot-scope="scope">
							{{scope.row.dianzhuangbianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="tupian" width="200" label="图片">
						<template slot-scope="scope">
							<div v-if="scope.row.tupian">
								<img v-if="scope.row.tupian.substring(0,4)=='http'" :src="scope.row.tupian.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.tupian.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="dianzhuangzhuangtai"
					label="电桩状态">
						<template slot-scope="scope">
							{{scope.row.dianzhuangzhuangtai}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="dianzhuangfenlei"
					label="电桩分类">
						<template slot-scope="scope">
							{{scope.row.dianzhuangfenlei}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shurudianya"
					label="输入电压">
						<template slot-scope="scope">
							{{scope.row.shurudianya}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shuchugonglv"
					label="输出功率">
						<template slot-scope="scope">
							{{scope.row.shuchugonglv}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shiyongfangshi"
					label="使用方式">
						<template slot-scope="scope">
							{{scope.row.shiyongfangshi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xiaoshidanjia"
					label="小时单价">
						<template slot-scope="scope">
							{{scope.row.xiaoshidanjia}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="weizhi"
					label="位置">
						<template slot-scope="scope">
							{{scope.row.weizhi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="zhuyishixiang"
					label="注意事项">
						<template slot-scope="scope">
							{{scope.row.zhuyishixiang}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('chongdianzhuang','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('chongdianzhuang','立即预约')" type="success" size="mini" @click="chongdianzhuangyuyueCrossAddOrUpdateHandler(scope.row,'cross','','dianzhuangzhuangtai','已预定','已预定,可预定'.split(',')[0])">立即预约</el-button>
							<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('chongdianzhuang','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"2px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(135.00000715255737, 154.00000602006912, 108.00000116229057, 1), rgba(226.0000017285347, 226.0000017285347, 226.0000017285347, 0.3799999952316284)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('chongdianzhuang','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="false"
					:style='{"padding":"0","margin":"20px 0 ","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"70%","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<chongdianzhuangyuyue-cross-add-or-update v-if="chongdianzhuangyuyueCrossAddOrUpdateFlag" :parent="this" ref="chongdianzhuangyuyueCrossaddOrUpdate"></chongdianzhuangyuyue-cross-add-or-update>




	</div>
</template>

<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import chongdianzhuangyuyueCrossAddOrUpdate from "../chongdianzhuangyuyue/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      chongdianzhuangyuyueCrossAddOrUpdateFlag: false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    chongdianzhuangyuyueCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    chongdianzhuangyuyueCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.chongdianzhuangyuyueCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','chongdianzhuang');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.chongdianzhuangyuyueCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.chongdianzhuangyuyueCrossaddOrUpdate.init(row.id,type);
      });
    },







    init () {
          this.dianzhuangzhuangtaiOptions = "已预定,可预定".split(',')
          this.dianzhuangfenleiOptions = "落地式,挂壁式".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.dianzhuangbianhao!='' && this.searchForm.dianzhuangbianhao!=undefined){
            params['dianzhuangbianhao'] = '%' + this.searchForm.dianzhuangbianhao + '%'
          }
           if(this.searchForm.dianzhuangzhuangtai!='' && this.searchForm.dianzhuangzhuangtai!=undefined){
            params['dianzhuangzhuangtai'] = this.searchForm.dianzhuangzhuangtai
          }
           if(this.searchForm.dianzhuangfenlei!='' && this.searchForm.dianzhuangfenlei!=undefined){
            params['dianzhuangfenlei'] = this.searchForm.dianzhuangfenlei
          }
           if(this.searchForm.xiaoshidanjiastart!='' && this.searchForm.xiaoshidanjiastart!=undefined ){
            params['xiaoshidanjiastart'] = this.searchForm.xiaoshidanjiastart
          }
          if(this.searchForm.xiaoshidanjiaend!='' && this.searchForm.xiaoshidanjiaend!=undefined){
            params['xiaoshidanjiaend'] = this.searchForm.xiaoshidanjiaend
          }
           if(this.searchForm.weizhi!='' && this.searchForm.weizhi!=undefined){
            params['weizhi'] = '%' + this.searchForm.weizhi + '%'
          }
      this.$http({
        url: "chongdianzhuang/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "chongdianzhuang/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 0px solid;
				border-radius: 0;
				padding: 0 10px;
				box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
				outline: none;
				margin: 0 auto;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 0;
				border-radius: 0;
				padding: 0 10px;
				box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
				outline: none;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 0;
				border-radius: 0;
				padding: 0 10px 0 30px;
				box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
				outline: none;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #fff;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				background: rgba(135, 154, 108, 1);
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #333;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: rgba(135, 154, 108, 1);
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: rgba(135, 154, 108, 1);
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
