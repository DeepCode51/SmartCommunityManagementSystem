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
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="select" v-if="type!='info'"  label="月份" prop="yuefen">
					<el-select :disabled="ro.yuefen" v-model="ruleForm.yuefen" placeholder="请选择月份" >
						<el-option
							v-for="(item,index) in yuefenOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="月份" prop="yuefen">
					<el-input v-model="ruleForm.yuefen"
						placeholder="月份" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="select" v-if="type!='info'" label="业主账号" prop="yezhuzhanghao">
					<el-select :disabled="ro.yezhuzhanghao" @change="yezhuzhanghaoChange" v-model="ruleForm.yezhuzhanghao" placeholder="请选择业主账号">
						<el-option
							v-for="(item,index) in yezhuzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-else-if="ruleForm.yezhuzhanghao" label="业主账号" prop="yezhuzhanghao">
					<el-input v-model="ruleForm.yezhuzhanghao" placeholder="业主账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="业主姓名" prop="yezhuxingming">
					<el-input v-model="ruleForm.yezhuxingming" placeholder="业主姓名" clearable  :readonly="ro.yezhuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="业主姓名" prop="yezhuxingming">
					<el-input v-model="ruleForm.yezhuxingming" placeholder="业主姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="楼栋" prop="loudong">
					<el-input v-model="ruleForm.loudong" placeholder="楼栋" clearable  :readonly="ro.loudong"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="楼栋" prop="loudong">
					<el-input v-model="ruleForm.loudong" placeholder="楼栋" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="房号" prop="fanghao">
					<el-input v-model="ruleForm.fanghao" placeholder="房号" clearable  :readonly="ro.fanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="房号" prop="fanghao">
					<el-input v-model="ruleForm.fanghao" placeholder="房号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="水费" prop="shuifei">
					<el-input v-model="ruleForm.shuifei" placeholder="水费" clearable  :readonly="ro.shuifei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="水费" prop="shuifei">
					<el-input v-model="ruleForm.shuifei" placeholder="水费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="电费" prop="dianfei">
					<el-input v-model="ruleForm.dianfei" placeholder="电费" clearable  :readonly="ro.dianfei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="电费" prop="dianfei">
					<el-input v-model="ruleForm.dianfei" placeholder="电费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="物业费" prop="wuyefei">
					<el-input v-model="ruleForm.wuyefei" placeholder="物业费" clearable  :readonly="ro.wuyefei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' v-else class="input" label="物业费" prop="wuyefei">
					<el-input v-model="ruleForm.wuyefei" placeholder="物业费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-if="type!='info'" label="总费用" prop="zongfeiyong">
					<el-input v-model="zongfeiyong" placeholder="总费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-else-if="ruleForm.zongfeiyong" label="总费用" prop="zongfeiyong">
					<el-input v-model="ruleForm.zongfeiyong" placeholder="总费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.fabushijian" 
						type="datetime"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px","display":"inline-block"}' class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
				</el-form-item>
			</template>
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
				yuefen : false,
				yezhuzhanghao : false,
				yezhuxingming : false,
				loudong : false,
				fanghao : false,
				shuifei : false,
				dianfei : false,
				wuyefei : false,
				zongfeiyong : false,
				fabushijian : false,
				ispay : false,
				userid : false,
			},
			
			
			ruleForm: {
				yuefen: '',
				yezhuzhanghao: '',
				yezhuxingming: '',
				loudong: '',
				fanghao: '',
				shuifei: '',
				dianfei: '',
				wuyefei: '',
				zongfeiyong: '',
				fabushijian: '',
				userid: '',
			},
		
			yuefenOptions: [],
			yezhuzhanghaoOptions: [],
			
			rules: {
				yuefen: [
				],
				yezhuzhanghao: [
				],
				yezhuxingming: [
				],
				loudong: [
				],
				fanghao: [
				],
				shuifei: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				dianfei: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				wuyefei: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				zongfeiyong: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				fabushijian: [
				],
				ispay: [
				],
				userid: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		zongfeiyong: {
			get: function () {
				return 0+parseFloat(this.ruleForm.shuifei==""?0:this.ruleForm.shuifei)+parseFloat(this.ruleForm.dianfei==""?0:this.ruleForm.dianfei)+parseFloat(this.ruleForm.wuyefei==""?0:this.ruleForm.wuyefei) || 0
			}
		},



	},
	created() {
		this.ruleForm.fabushijian = this.getCurDateTime()
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
						if(o=='yuefen'){
							this.ruleForm.yuefen = obj[o];
							this.ro.yuefen = true;
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
						if(o=='loudong'){
							this.ruleForm.loudong = obj[o];
							this.ro.loudong = true;
							continue;
						}
						if(o=='fanghao'){
							this.ruleForm.fanghao = obj[o];
							this.ro.fanghao = true;
							continue;
						}
						if(o=='shuifei'){
							this.ruleForm.shuifei = obj[o];
							this.ro.shuifei = true;
							continue;
						}
						if(o=='dianfei'){
							this.ruleForm.dianfei = obj[o];
							this.ro.dianfei = true;
							continue;
						}
						if(o=='wuyefei'){
							this.ruleForm.wuyefei = obj[o];
							this.ro.wuyefei = true;
							continue;
						}
						if(o=='zongfeiyong'){
							this.ruleForm.zongfeiyong = obj[o];
							this.ro.zongfeiyong = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
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
					if(((json.yuefen!=''&&json.yuefen) || json.yuefen==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yuefen = json.yuefen
						this.ro.yuefen = true;
					}
					if(((json.yezhuzhanghao!=''&&json.yezhuzhanghao) || json.yezhuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yezhuzhanghao = json.yezhuzhanghao
						this.ro.yezhuzhanghao = true;
					}
					if(((json.yezhuxingming!=''&&json.yezhuxingming) || json.yezhuxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yezhuxingming = json.yezhuxingming
						this.ro.yezhuxingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.yuefenOptions = "1月份,2月份,3月份,4月份,5月份,6月份,7月份,8月份,9月份,10月份,11月份,12月份".split(',')
            this.$http({
				url: `option/yezhuxinxi/yezhuzhanghao`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.yezhuzhanghaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
			// 下二随
			yezhuzhanghaoChange () {
				this.$http({
					url: `follow/yezhuxinxi/yezhuzhanghao?columnValue=`+ this.ruleForm.yezhuzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.yezhuxingming){
							this.ruleForm.yezhuxingming = data.data.yezhuxingming
						}
						if(data.data.loudong){
							this.ruleForm.loudong = data.data.loudong
						}
						if(data.data.fanghao){
							this.ruleForm.fanghao = data.data.fanghao
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `wuyejiaofei/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.zongfeiyong = this.zongfeiyong

























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
				url: "wuyejiaofei/page", 
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
					   url: `wuyejiaofei/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.wuyejiaofeiCrossAddOrUpdateFlag = false;
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
			   url: `wuyejiaofei/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.wuyejiaofeiCrossAddOrUpdateFlag = false;
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
      this.parent.wuyejiaofeiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
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
