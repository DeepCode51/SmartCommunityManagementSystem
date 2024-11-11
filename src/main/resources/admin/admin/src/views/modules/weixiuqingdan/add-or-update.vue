<template>
	<div class="addEdit-block" :style='{"padding":"30px 0 0"}' style="width: 100%;">
		<el-form
			:style='{"width":"86%","padding":"30px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"0 auto","borderRadius":"6px","background":"rgba(255,255,255,.8)"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="140px"
		>
			<template >
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="报修单号" prop="baoxiudanhao">
					<el-input v-model="ruleForm.baoxiudanhao" placeholder="报修单号" clearable  :readonly="ro.baoxiudanhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="报修单号" prop="baoxiudanhao">
					<el-input v-model="ruleForm.baoxiudanhao" placeholder="报修单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="报修标题" prop="baoxiubiaoti">
					<el-input v-model="ruleForm.baoxiubiaoti" placeholder="报修标题" clearable  :readonly="ro.baoxiubiaoti"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="报修标题" prop="baoxiubiaoti">
					<el-input v-model="ruleForm.baoxiubiaoti" placeholder="报修标题" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="upload" v-if="type!='info' && !ro.shigongtupian" label="施工图片" prop="shigongtupian">
					<file-upload
						tip="点击上传施工图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.shigongtupian?ruleForm.shigongtupian:''"
						@change="shigongtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="upload" v-else-if="ruleForm.shigongtupian" label="施工图片" prop="shigongtupian">
					<img v-if="ruleForm.shigongtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shigongtupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shigongtupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="维修金额" prop="weixiujine">
					<el-input v-model="ruleForm.weixiujine" placeholder="维修金额" clearable  :readonly="ro.weixiujine"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="维修金额" prop="weixiujine">
					<el-input v-model="ruleForm.weixiujine" placeholder="维修金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="date" v-if="type!='info'" label="完工时间" prop="wangongshijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.wangongshijian" 
						type="date"
						:readonly="ro.wangongshijian"
						placeholder="完工时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-else-if="ruleForm.wangongshijian" label="完工时间" prop="wangongshijian">
					<el-input v-model="ruleForm.wangongshijian" placeholder="完工时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="业主账号" prop="yezhuzhanghao">
					<el-input v-model="ruleForm.yezhuzhanghao" placeholder="业主账号" clearable  :readonly="ro.yezhuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="业主账号" prop="yezhuzhanghao">
					<el-input v-model="ruleForm.yezhuzhanghao" placeholder="业主账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="业主姓名" prop="yezhuxingming">
					<el-input v-model="ruleForm.yezhuxingming" placeholder="业主姓名" clearable  :readonly="ro.yezhuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="业主姓名" prop="yezhuxingming">
					<el-input v-model="ruleForm.yezhuxingming" placeholder="业主姓名" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-if="type!='info'"  label="故障报告" prop="guzhangbaogao">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.guzhangbaogao" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else-if="ruleForm.guzhangbaogao" label="故障报告" prop="guzhangbaogao">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.guzhangbaogao"></span>
                </el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-if="type!='info'"  label="维修详情" prop="weixiuxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.weixiuxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else-if="ruleForm.weixiuxiangqing" label="维修详情" prop="weixiuxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.weixiuxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(135, 154, 108, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				baoxiudanhao : false,
				baoxiubiaoti : false,
				shigongtupian : false,
				weixiujine : false,
				guzhangbaogao : false,
				weixiuxiangqing : false,
				wangongshijian : false,
				yezhuzhanghao : false,
				yezhuxingming : false,
				sfsh : false,
				shhf : false,
				ispay : false,
			},
			
			
			ruleForm: {
				baoxiudanhao: '',
				baoxiubiaoti: '',
				shigongtupian: '',
				weixiujine: '',
				guzhangbaogao: '',
				weixiuxiangqing: '',
				wangongshijian: '',
				yezhuzhanghao: '',
				yezhuxingming: '',
				shhf: '',
			},
		
			
			rules: {
				baoxiudanhao: [
				],
				baoxiubiaoti: [
				],
				shigongtupian: [
				],
				weixiujine: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				guzhangbaogao: [
				],
				weixiuxiangqing: [
				],
				wangongshijian: [
				],
				yezhuzhanghao: [
				],
				yezhuxingming: [
				],
				sfsh: [
				],
				shhf: [
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
		this.ruleForm.wangongshijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='baoxiudanhao'){
							this.ruleForm.baoxiudanhao = obj[o];
							this.ro.baoxiudanhao = true;
							continue;
						}
						if(o=='baoxiubiaoti'){
							this.ruleForm.baoxiubiaoti = obj[o];
							this.ro.baoxiubiaoti = true;
							continue;
						}
						if(o=='shigongtupian'){
							this.ruleForm.shigongtupian = obj[o];
							this.ro.shigongtupian = true;
							continue;
						}
						if(o=='weixiujine'){
							this.ruleForm.weixiujine = obj[o];
							this.ro.weixiujine = true;
							continue;
						}
						if(o=='guzhangbaogao'){
							this.ruleForm.guzhangbaogao = obj[o];
							this.ro.guzhangbaogao = true;
							continue;
						}
						if(o=='weixiuxiangqing'){
							this.ruleForm.weixiuxiangqing = obj[o];
							this.ro.weixiuxiangqing = true;
							continue;
						}
						if(o=='wangongshijian'){
							this.ruleForm.wangongshijian = obj[o];
							this.ro.wangongshijian = true;
							continue;
						}
						if(o=='yezhuzhanghao'){
							this.ruleForm.yezhuzhanghao = obj[o];
							this.ro.yezhuzhanghao = true;
							continue;
						}
						if(o=='yezhuxingming'){
							this.ruleForm.yezhuxingming = obj[o];
							this.ro.yezhuxingming = true;
							continue;
						}
				}
				












			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `weixiuqingdan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.guzhangbaogao = this.ruleForm.guzhangbaogao.replace(reg,'../../../springbootjcmah/upload');
        this.ruleForm.weixiuxiangqing = this.ruleForm.weixiuxiangqing.replace(reg,'../../../springbootjcmah/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.shigongtupian!=null) {
		this.ruleForm.shigongtupian = this.ruleForm.shigongtupian.replace(new RegExp(this.$base.url,"g"),"");
	}



















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "weixiuqingdan/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `weixiuqingdan/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.weixiuqingdanCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `weixiuqingdan/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.weixiuqingdanCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.weixiuqingdanCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    shigongtupianUploadChange(fileUrls) {
	    this.ruleForm.shigongtupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  font-weight: 500;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: rgba(121, 121, 121, 1);
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 400px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: rgba(121, 121, 121, 1);
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: rgba(121, 121, 121, 1);
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: rgba(121, 121, 121, 1);
	  	  width: 100%;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
