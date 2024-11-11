<template>
<div>
	<div :style='{"width":"1200px","padding":"10px","margin":"12px auto 0","borderRadius":"16px","background":"linear-gradient(284deg, rgba(85,205,129,1) 0%, rgba(61,183,105,1) 100%),#3db769"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'///'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"width":"1200px","padding":"10px","margin":"12px auto 0","borderRadius":"16px","background":"linear-gradient(284deg, rgba(85,205,129,1) 0%, rgba(61,183,105,1) 100%),#3db769"}' class="breadcrumb-preview">
        <el-form :inline="true" :model="formSearch" class="list-form-pv" style="justify-content: center;display: flex;">
            <div class="section-btn">
                <el-form-item>
                  <el-input v-model="title" placeholder="标题"></el-input>
                </el-form-item>
              <el-button type="primary" @click="getNewsList(1)"><i class="el-icon-search"></i>查询</el-button>
            </div>
        </el-form>
	</div>
	
	<div class="news-preview" :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px auto 0 auto","borderRadius":"8px","background":"rgba(255,255,255,1)","width":"1200px","position":"relative","height":"auto"}'>
				
				
				<!-- 样式三 -->
		<div class="list3 index-pv1" :style='{"width":"100%","margin":"0 0 20px","background":"none","height":"auto"}'>
			<div :style='{"cursor":"pointer","padding":"20px","margin":"0px 0","borderColor":"#bee4cc","background":"none","borderWidth":"0 0 1px 0","width":"100%","position":"relative","borderStyle":"solid","height":"auto"}' v-for="item in newsList" :key="item.id" @click="toNewsDetail(item)" class="list-item animation-box">
				<div :style='{"margin":"0 100px 10px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","textAlign":"left","background":"none","width":"calc(100% - 180px)","lineHeight":"28px","fontSize":"16px","textOverflow":"ellipsis"}' class="title ">{{item.title}}</div>
				<div :style='{"margin":"0 100px","whiteSpace":"nowrap","overflow":"hidden","color":"#666","textAlign":"left","background":"none","width":"calc(100% - 180px)","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis","height":"24px"}' class="introduction ">{{item.introduction}}</div>
				<div :style='{"lineHeight":"32px","fontSize":"12px","position":"absolute","right":"10px","color":"#999","top":"20px"}' class="time ">{{item.addtime}}</div>
				<div :style='{"padding":"12px","color":"#fff","borderRadius":"12px","textAlign":"center","background":"radial-gradient(circle, rgba(95,218,140,1) 0%, rgba(61,183,105,1) 100%)","bottom":"10px","display":"inline-block","width":"40px","fontSize":"14px","lineHeight":"1.1","position":"absolute","height":"80px"}' class="tags ">新闻动态</div>
			</div>
		</div>
				
				
				
				
				
		<el-pagination
		  background
		  class="pagination"
		  :pager-count="7"
		  :page-size="pageSize"
		  :page-sizes="pageSizes"
		  prev-text="上一页"
		  next-text="下一页"
		  :hide-on-single-page="false"
		  :layout='["total","prev","pager","next","sizes","jumper"].join()'
		  :total="total"
		  :style='{"width":"1200px","margin":"20px auto","whiteSpace":"nowrap","color":"#333"}'
		  @current-change="curChange"
		  @prev-click="prevClick"
		  @next-click="nextClick"
		></el-pagination>
	</div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: this.$config.baseUrl,
        breadcrumbItem: [
          {
            name: '社区公告'
          }
        ],
        newsList: [],
        total: 1,
        pageSize: 10,pageSizes: [10,20,30,50],
        totalPage: 1,
		layouts: '',
        title: '',
      }
    },
    created() {
		this.getNewsList(1);
    },
    //方法集合
    methods: {
      getNewsList(page) {
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if(this.title != '') searchWhere.title = '%' + this.title + '%';
        this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.newsList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      curChange(page) {
        this.getNewsList(page);
      },
      prevClick(page) {
        this.getNewsList(page);
      },
      nextClick(page) {
        this.getNewsList(page);
      },
      toNewsDetail(item) {
        this.$router.push({path: '/index/newsDetail', query: {detailObj: JSON.stringify(item)}});
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.news-wrap {
	  width: 1000px;
	  margin: 0 auto;
	}
	.news-item {
	  height: 200px;
	  width: auto;
	  margin-bottom: 30px;
	  cursor: pointer;
	}
	.news-item-text {
	  width: calc(100% - 215px);
	  display: inline-block;
	  vertical-align: top;
	  margin-left: 15px;
	}
	.news-item-text-title {
	  font-size: 16px;
	  margin-bottom: 15px;
	}
	.news-item-text-intro {
	  font-size: 14px;
	  color: #666;
	}
	
	.hide1 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 1;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.hide2 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.hide3 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 3;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	
	.index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.index-pv1 .animation-box:hover {
				transform: translate3d(-2px, -2px, 20px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
	}
	
	.index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.index-pv1 .animation-box img:hover {
				transform: 0;
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		
	.el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #3db769;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #3db769;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}
	
	.el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				border-radius: 2px;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				line-height: 28px;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #3db769;
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
	
	.el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #3db769;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #fff;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #3db769;
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
	
	.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.el-pagination /deep/ .el-pagination__jump .el-input {
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
	
	.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 3px;
				color: #3db769;
				background: #FFF;
				display: inline-block;
				width: 100%;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
				height: 28px;
			}
</style>
