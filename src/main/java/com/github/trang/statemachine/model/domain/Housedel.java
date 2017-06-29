package com.github.trang.statemachine.model.domain;

import com.google.common.base.MoreObjects;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "sh_housedel")
public class Housedel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键，本次房源委托编码，12位长
     */
    @Id
    @Column(name = "housedel_code")
    @GeneratedValue(generator = "JDBC")
    private Long housedelCode;
    /**
     * 委托类型 1买卖 2出租
     */
    @Column(name = "del_type")
    private Integer delType;
    /**
     * 房源委托状态,参考EnumHousedelStatus.
     * INPOOL(11,"掉入资源池"),
     * INVALID(0,"无效"),
     * VALID(1,"有效"),
     * EARNEST(2, "意向金"),
     * DEPOSIT(3, "定金"),
     * DRAFT(4, "起草合同"),
     * SEAL(5, "合同盖章"),
     * SIGN(6, "合同签约"),
     * TRANSFER(7,"过户");
     */
    @Column(name = "del_status")
    private Integer delStatus;
    /**
     * 二维码图片地址
     */
    @Column(name = "two_dimension")
    private String twoDimension;
    /**
     * 外键、house表ID
     */
    @Column(name = "house_id")
    private Long houseId;
    /**
     * 楼盘字典房屋ID
     */
    @Column(name = "standard_house_id")
    private Long standardHouseId;
    /**
     * 价格 单位元
     */
    private BigDecimal price;
    /**
     * 价格变化情况 0没有变化 1上升 -1下降
     */
    @Column(name = "price_change_type")
    private Integer priceChangeType;
    /**
     * 等级，目前为A,B,C
     */
    @Column(name = "del_grade")
    private String delGrade;
    /**
     * 房源等级原因
     */
    @Column(name = "grade_reason")
    private String gradeReason;
    @Column(name = "sale_reason")
    private String saleReason;
    /**
     * 是否共有产权
     */
    @Column(name = "is_intercommunity")
    private String isIntercommunity;
    /**
     * 是否唯一
     */
    @Column(name = "is_unique")
    private String isUnique;
    /**
     * 抵押信息-基础数据表
     */
    @Column(name = "guaranty_info")
    private String guarantyInfo;
    /**
     * 抵押金额、单位元
     */
    @Column(name = "guaranty_money")
    private BigDecimal guarantyMoney;
    /**
     * 抵押银行
     */
    @Column(name = "guaranty_bank")
    private String guarantyBank;
    /**
     * 抵押贷款还款类型-基础数据表
     */
    @Column(name = "guaranty_repay_type")
    private String guarantyRepayType;
    /**
     * 户口状态-基础数据表
     */
    @Column(name = "residence_status")
    private String residenceStatus;
    /**
     * 婚姻状况
     */
    private String marriage;
    /**
     * 原购价格 单位元
     */
    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;
    /**
     * 交易属性-基础数据表
     */
    @Column(name = "payment_mode")
    private String paymentMode;
    /**
     * 过户指导价格 单位元
     */
    @Column(name = "guide_price")
    private BigDecimal guidePrice;
    /**
     * 房本登记日期
     */
    @Column(name = "register_time")
    private Date registerTime;
    @Column(name = "register_photo")
    private String registerPhoto;
    /**
     * 原购房合同日期
     */
    @Column(name = "purchase_time")
    private Date purchaseTime;
    @Column(name = "purchase_photo")
    private String purchasePhoto;
    /**
     * 契税日期
     */
    @Column(name = "deed_time")
    private Date deedTime;
    @Column(name = "deed_photo")
    private String deedPhoto;
    /**
     * 租赁方式-基础数据表
     */
    @Column(name = "rent_type")
    private String rentType;
    /**
     * 租期-基础数据表
     */
    @Column(name = "rent_deadline")
    private String rentDeadline;
    /**
     * 房租付款方式-基础数据表
     */
    @Column(name = "rent_pay_way")
    private String rentPayWay;
    /**
     * 配套设施
     */
    @Column(name = "rent_facility")
    private String rentFacility;
    /**
     * 房屋状态，出租中等-基础数据表
     */
    @Column(name = "house_status")
    private String houseStatus;
    /**
     * 出租到期时间
     */
    @Column(name = "rent_end_date")
    private String rentEndDate;
    /**
     * 租户姓名及电话
     */
    @Column(name = "rent_name_phone")
    private String rentNamePhone;
    /**
     * 房屋状态特殊提醒、备注
     */
    @Column(name = "status_remark")
    private String statusRemark;
    /**
     * 装修-基础数据表
     */
    @Column(name = "fitment_status")
    private String fitmentStatus;
    /**
     * 特殊备注
     */
    @Column(name = "special_remark")
    private String specialRemark;
    /**
     * 录入人UCID
     */
    @Column(name = "creator_ucid")
    private Long creatorUcid;
    /**
     * 录入人姓名
     */
    @Column(name = "creator_name")
    private String creatorName;
    /**
     * 录入人店组
     */
    @Column(name = "creator_org_code")
    private String creatorOrgCode;
    /**
     * 录入人角色
     */
    @Column(name = "creator_role")
    private String creatorRole;
    /**
     * 录入时间
     */
    @Column(name = "created_time")
    private Date createdTime;
    /**
     * 维护人UCID
     */
    @Column(name = "holder_ucid")
    private Long holderUcid;
    /**
     * 维护人姓名
     */
    @Column(name = "holder_name")
    private String holderName;
    /**
     * 维护人店组
     */
    @Column(name = "holder_org_code")
    private String holderOrgCode;
    /**
     * 维护人角色
     */
    @Column(name = "holder_role")
    private String holderRole;
    /**
     * 成为维护人时间
     */
    @Column(name = "holder_time")
    private Date holderTime;
    /**
     * 实堪人UCID
     */
    @Column(name = "appro_broker_ucid")
    private Long approBrokerUcid;
    /**
     * 实堪人姓名
     */
    @Column(name = "appro_broker_name")
    private String approBrokerName;
    /**
     * 实堪人店组
     */
    @Column(name = "appro_broker_org_code")
    private String approBrokerOrgCode;
    /**
     * 实堪人角色
     */
    @Column(name = "appro_broker_role")
    private String approBrokerRole;
    /**
     * 成为实堪人时间
     */
    @Column(name = "appro_broker_time")
    private Date approBrokerTime;
    /**
     * 钥匙人UCID
     */
    @Column(name = "key_broker_ucid")
    private Long keyBrokerUcid;
    /**
     * 钥匙人姓名
     */
    @Column(name = "key_broker_name")
    private String keyBrokerName;
    /**
     * 钥匙人店组
     */
    @Column(name = "key_broker_org_code")
    private String keyBrokerOrgCode;
    /**
     * 钥匙人角色
     */
    @Column(name = "key_broker_role")
    private String keyBrokerRole;
    /**
     * 成为钥匙人时间
     */
    @Column(name = "key_broker_time")
    private Date keyBrokerTime;
    /**
     * 速消人UCID
     */
    @Column(name = "fast_broker_ucid")
    private Long fastBrokerUcid;
    /**
     * 速消人姓名
     */
    @Column(name = "fast_broker_name")
    private String fastBrokerName;
    /**
     * 速销人店组
     */
    @Column(name = "fast_broker_org_code")
    private String fastBrokerOrgCode;
    /**
     * 速销人角色
     */
    @Column(name = "fast_broker_role")
    private String fastBrokerRole;
    /**
     * 成为速消时间
     */
    @Column(name = "fast_broker_time")
    private Date fastBrokerTime;
    /**
     * 签约人UCID
     */
    @Column(name = "sign_broker_ucid")
    private Long signBrokerUcid;
    /**
     * 签约人姓名
     */
    @Column(name = "sign_broker_name")
    private String signBrokerName;
    /**
     * 签约时间
     */
    @Column(name = "sign_broker_time")
    private Date signBrokerTime;
    /**
     * 急售房源状态 0或空：非 1申请状态 2审批通过 4审批拒绝 8过期
     */
    @Column(name = "hurry_status")
    private Integer hurryStatus;
    /**
     * 急售状态改变时间
     */
    @Column(name = "hurry_time")
    private Date hurryTime;
    /**
     * 聚焦状态 0或空：非 1申请状态 2审批通过 4审批拒绝 8过期
     */
    @Column(name = "focus_status")
    private Integer focusStatus;
    /**
     * 聚焦状态改变时间
     */
    @Column(name = "focus_time")
    private Date focusTime;
    /**
     * 特殊房源状态 0或空：非 1申请状态 2审批通过 4审批拒绝 8过期
     */
    @Column(name = "special_status")
    private Integer specialStatus;
    /**
     * 特殊房源状态改变时间
     */
    @Column(name = "special_time")
    private Date specialTime;
    /**
     * 暂缓状态 0或空：非 1申请状态 2审批通过 4审批拒绝 8过期
     */
    @Column(name = "pause_status")
    private Integer pauseStatus;
    /**
     * 暂缓状态改变时间
     */
    @Column(name = "pause_time")
    private Date pauseTime;
    /**
     * 无效状态 0或空：非 1申请状态 2审批通过 4审批拒绝 8过期
     */
    @Column(name = "invalid_status")
    private Integer invalidStatus;
    /**
     * 无效状态改变时间
     */
    @Column(name = "invalid_time")
    private Date invalidTime;
    /**
     * 连环单状态 0或空：非 1连环单 2取消
     */
    @Column(name = "serial_status")
    private Integer serialStatus;
    /**
     * 状态改变时间
     */
    @Column(name = "serial_time")
    private Date serialTime;
    /**
     * 超期提醒状态 0或空：非 1：超期提醒中 2：取消
     */
    @Column(name = "overdue_warn_status")
    private Integer overdueWarnStatus;
    /**
     * 状态改变时间
     */
    @Column(name = "overdue_warn_time")
    private Date overdueWarnTime;
    /**
     * 更新人UCID
     */
    @Column(name = "updated_ucid")
    private Long updatedUcid;
    /**
     * 更新人姓名
     */
    @Column(name = "updated_name")
    private String updatedName;
    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;
    /**
     * 是否限购
     */
    @Column(name = "is_limit_buy")
    private String isLimitBuy;
    /**
     * 房屋用途-基础数据表
     */
    @Column(name = "house_usage")
    private String houseUsage;
    /**
     * 速消人类型(尚未启用)，1，2，3
     */
    @Column(name = "fast_broker_type")
    private Integer fastBrokerType;
    /**
     * 城市编码
     */
    @Column(name = "office_address")
    private Integer officeAddress;
    /**
     * 录入来源
     */
    @Column(name = "add_resource")
    private String addResource;
    /**
     * 委托来源,选项1-基础数据表
     */
    @Column(name = "del_source_sup")
    private String delSourceSup;
    /**
     * 委托来源,选项2-基础数据表
     */
    @Column(name = "del_source_sub")
    private String delSourceSub;
    /**
     * 业主姓名
     */
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "owner_weixin")
    private String ownerWeixin;
    @Column(name = "owner_mobile_phone1")
    private String ownerMobilePhone1;
    @Column(name = "owner_mobile_phone2")
    private String ownerMobilePhone2;
    @Column(name = "owner_home_phone")
    private String ownerHomePhone;
    /**
     * 另外联系人姓名
     */
    @Column(name = "linker_other_name")
    private String linkerOtherName;
    @Column(name = "linker_other_mobile_phone")
    private String linkerOtherMobilePhone;
    /**
     * 另外联系人和业主的关系-基础数据表
     */
    @Column(name = "linker_other_relation")
    private String linkerOtherRelation;
    /**
     * 看房时间
     */
    @Column(name = "appro_time")
    private String approTime;
    /**
     * 普通委托人
     */
    @Column(name = "ordinary_broker_ucid")
    private Long ordinaryBrokerUcid;
    /**
     * 普通委托人姓名
     */
    @Column(name = "ordinary_broker_name")
    private String ordinaryBrokerName;
    /**
     * 签约人店组
     */
    @Column(name = "ordinary_broker_org_code")
    private String ordinaryBrokerOrgCode;
    /**
     * 签约人角色
     */
    @Column(name = "ordinary_broker_role")
    private String ordinaryBrokerRole;
    /**
     * 成为普通委托人时间
     */
    @Column(name = "ordinary_broker_time")
    private Date ordinaryBrokerTime;
    /**
     * 房源信息检查，参考EnumHousedelMsgCheck："price_unit_exceed", "单价过高" "price_unit_exceed_pass", "单价过高审核通过"
     * "price_unit_exceed_refuse", "单价过高审核拒绝"
     */
    @Column(name = "msg_check")
    private String msgCheck;
    /**
     * 是否在共享池中 0代表不是 1代表是
     */
    @Column(name = "is_pool")
    private Integer isPool;
    /**
     * 房屋等级变化时间
     */
    @Column(name = "del_grade_time")
    private Date delGradeTime;
    @Column(name = "login_client")
    private Boolean loginClient;
    /**
     * 建筑面积
     */
    @Column(name = "build_area")
    private BigDecimal buildArea;
    /**
     * 单价过高原因
     */
    @Column(name = "high_unit_price_reason")
    private String highUnitPriceReason;
    /**
     * 盘点分数
     */
    @Column(name = "inventory_score")
    private Float inventoryScore;
    /**
     * 投票总数
     */
    @Column(name = "vote_count")
    private Integer voteCount;
    @Column(name = "price_update_time")
    private Date priceUpdateTime;

    public Long getHousedelCode() {
        return housedelCode;
    }

    public void setHousedelCode(Long housedelCode) {
        this.housedelCode = housedelCode;
    }

    public Integer getDelType() {
        return delType;
    }

    public void setDelType(Integer delType) {
        this.delType = delType;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public String getTwoDimension() {
        return twoDimension;
    }

    public void setTwoDimension(String twoDimension) {
        this.twoDimension = twoDimension == null ? null : twoDimension.trim();
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getStandardHouseId() {
        return standardHouseId;
    }

    public void setStandardHouseId(Long standardHouseId) {
        this.standardHouseId = standardHouseId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPriceChangeType() {
        return priceChangeType;
    }

    public void setPriceChangeType(Integer priceChangeType) {
        this.priceChangeType = priceChangeType;
    }

    public String getDelGrade() {
        return delGrade;
    }

    public void setDelGrade(String delGrade) {
        this.delGrade = delGrade == null ? null : delGrade.trim();
    }

    public String getGradeReason() {
        return gradeReason;
    }

    public void setGradeReason(String gradeReason) {
        this.gradeReason = gradeReason == null ? null : gradeReason.trim();
    }

    public String getSaleReason() {
        return saleReason;
    }

    public void setSaleReason(String saleReason) {
        this.saleReason = saleReason == null ? null : saleReason.trim();
    }

    public String getIsIntercommunity() {
        return isIntercommunity;
    }

    public void setIsIntercommunity(String isIntercommunity) {
        this.isIntercommunity = isIntercommunity == null ? null : isIntercommunity.trim();
    }

    public String getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(String isUnique) {
        this.isUnique = isUnique == null ? null : isUnique.trim();
    }

    public String getGuarantyInfo() {
        return guarantyInfo;
    }

    public void setGuarantyInfo(String guarantyInfo) {
        this.guarantyInfo = guarantyInfo == null ? null : guarantyInfo.trim();
    }

    public BigDecimal getGuarantyMoney() {
        return guarantyMoney;
    }

    public void setGuarantyMoney(BigDecimal guarantyMoney) {
        this.guarantyMoney = guarantyMoney;
    }

    public String getGuarantyBank() {
        return guarantyBank;
    }

    public void setGuarantyBank(String guarantyBank) {
        this.guarantyBank = guarantyBank == null ? null : guarantyBank.trim();
    }

    public String getGuarantyRepayType() {
        return guarantyRepayType;
    }

    public void setGuarantyRepayType(String guarantyRepayType) {
        this.guarantyRepayType = guarantyRepayType == null ? null : guarantyRepayType.trim();
    }

    public String getResidenceStatus() {
        return residenceStatus;
    }

    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus == null ? null : residenceStatus.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode == null ? null : paymentMode.trim();
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterPhoto() {
        return registerPhoto;
    }

    public void setRegisterPhoto(String registerPhoto) {
        this.registerPhoto = registerPhoto == null ? null : registerPhoto.trim();
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchasePhoto() {
        return purchasePhoto;
    }

    public void setPurchasePhoto(String purchasePhoto) {
        this.purchasePhoto = purchasePhoto == null ? null : purchasePhoto.trim();
    }

    public Date getDeedTime() {
        return deedTime;
    }

    public void setDeedTime(Date deedTime) {
        this.deedTime = deedTime;
    }

    public String getDeedPhoto() {
        return deedPhoto;
    }

    public void setDeedPhoto(String deedPhoto) {
        this.deedPhoto = deedPhoto == null ? null : deedPhoto.trim();
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public String getRentDeadline() {
        return rentDeadline;
    }

    public void setRentDeadline(String rentDeadline) {
        this.rentDeadline = rentDeadline == null ? null : rentDeadline.trim();
    }

    public String getRentPayWay() {
        return rentPayWay;
    }

    public void setRentPayWay(String rentPayWay) {
        this.rentPayWay = rentPayWay == null ? null : rentPayWay.trim();
    }

    public String getRentFacility() {
        return rentFacility;
    }

    public void setRentFacility(String rentFacility) {
        this.rentFacility = rentFacility == null ? null : rentFacility.trim();
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus == null ? null : houseStatus.trim();
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate == null ? null : rentEndDate.trim();
    }

    public String getRentNamePhone() {
        return rentNamePhone;
    }

    public void setRentNamePhone(String rentNamePhone) {
        this.rentNamePhone = rentNamePhone == null ? null : rentNamePhone.trim();
    }

    public String getStatusRemark() {
        return statusRemark;
    }

    public void setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark == null ? null : statusRemark.trim();
    }

    public String getFitmentStatus() {
        return fitmentStatus;
    }

    public void setFitmentStatus(String fitmentStatus) {
        this.fitmentStatus = fitmentStatus == null ? null : fitmentStatus.trim();
    }

    public String getSpecialRemark() {
        return specialRemark;
    }

    public void setSpecialRemark(String specialRemark) {
        this.specialRemark = specialRemark == null ? null : specialRemark.trim();
    }

    public Long getCreatorUcid() {
        return creatorUcid;
    }

    public void setCreatorUcid(Long creatorUcid) {
        this.creatorUcid = creatorUcid;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public String getCreatorOrgCode() {
        return creatorOrgCode;
    }

    public void setCreatorOrgCode(String creatorOrgCode) {
        this.creatorOrgCode = creatorOrgCode == null ? null : creatorOrgCode.trim();
    }

    public String getCreatorRole() {
        return creatorRole;
    }

    public void setCreatorRole(String creatorRole) {
        this.creatorRole = creatorRole == null ? null : creatorRole.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getHolderUcid() {
        return holderUcid;
    }

    public void setHolderUcid(Long holderUcid) {
        this.holderUcid = holderUcid;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName == null ? null : holderName.trim();
    }

    public String getHolderOrgCode() {
        return holderOrgCode;
    }

    public void setHolderOrgCode(String holderOrgCode) {
        this.holderOrgCode = holderOrgCode == null ? null : holderOrgCode.trim();
    }

    public String getHolderRole() {
        return holderRole;
    }

    public void setHolderRole(String holderRole) {
        this.holderRole = holderRole == null ? null : holderRole.trim();
    }

    public Date getHolderTime() {
        return holderTime;
    }

    public void setHolderTime(Date holderTime) {
        this.holderTime = holderTime;
    }

    public Long getApproBrokerUcid() {
        return approBrokerUcid;
    }

    public void setApproBrokerUcid(Long approBrokerUcid) {
        this.approBrokerUcid = approBrokerUcid;
    }

    public String getApproBrokerName() {
        return approBrokerName;
    }

    public void setApproBrokerName(String approBrokerName) {
        this.approBrokerName = approBrokerName == null ? null : approBrokerName.trim();
    }

    public String getApproBrokerOrgCode() {
        return approBrokerOrgCode;
    }

    public void setApproBrokerOrgCode(String approBrokerOrgCode) {
        this.approBrokerOrgCode = approBrokerOrgCode == null ? null : approBrokerOrgCode.trim();
    }

    public String getApproBrokerRole() {
        return approBrokerRole;
    }

    public void setApproBrokerRole(String approBrokerRole) {
        this.approBrokerRole = approBrokerRole == null ? null : approBrokerRole.trim();
    }

    public Date getApproBrokerTime() {
        return approBrokerTime;
    }

    public void setApproBrokerTime(Date approBrokerTime) {
        this.approBrokerTime = approBrokerTime;
    }

    public Long getKeyBrokerUcid() {
        return keyBrokerUcid;
    }

    public void setKeyBrokerUcid(Long keyBrokerUcid) {
        this.keyBrokerUcid = keyBrokerUcid;
    }

    public String getKeyBrokerName() {
        return keyBrokerName;
    }

    public void setKeyBrokerName(String keyBrokerName) {
        this.keyBrokerName = keyBrokerName == null ? null : keyBrokerName.trim();
    }

    public String getKeyBrokerOrgCode() {
        return keyBrokerOrgCode;
    }

    public void setKeyBrokerOrgCode(String keyBrokerOrgCode) {
        this.keyBrokerOrgCode = keyBrokerOrgCode == null ? null : keyBrokerOrgCode.trim();
    }

    public String getKeyBrokerRole() {
        return keyBrokerRole;
    }

    public void setKeyBrokerRole(String keyBrokerRole) {
        this.keyBrokerRole = keyBrokerRole == null ? null : keyBrokerRole.trim();
    }

    public Date getKeyBrokerTime() {
        return keyBrokerTime;
    }

    public void setKeyBrokerTime(Date keyBrokerTime) {
        this.keyBrokerTime = keyBrokerTime;
    }

    public Long getFastBrokerUcid() {
        return fastBrokerUcid;
    }

    public void setFastBrokerUcid(Long fastBrokerUcid) {
        this.fastBrokerUcid = fastBrokerUcid;
    }

    public String getFastBrokerName() {
        return fastBrokerName;
    }

    public void setFastBrokerName(String fastBrokerName) {
        this.fastBrokerName = fastBrokerName == null ? null : fastBrokerName.trim();
    }

    public String getFastBrokerOrgCode() {
        return fastBrokerOrgCode;
    }

    public void setFastBrokerOrgCode(String fastBrokerOrgCode) {
        this.fastBrokerOrgCode = fastBrokerOrgCode == null ? null : fastBrokerOrgCode.trim();
    }

    public String getFastBrokerRole() {
        return fastBrokerRole;
    }

    public void setFastBrokerRole(String fastBrokerRole) {
        this.fastBrokerRole = fastBrokerRole == null ? null : fastBrokerRole.trim();
    }

    public Date getFastBrokerTime() {
        return fastBrokerTime;
    }

    public void setFastBrokerTime(Date fastBrokerTime) {
        this.fastBrokerTime = fastBrokerTime;
    }

    public Long getSignBrokerUcid() {
        return signBrokerUcid;
    }

    public void setSignBrokerUcid(Long signBrokerUcid) {
        this.signBrokerUcid = signBrokerUcid;
    }

    public String getSignBrokerName() {
        return signBrokerName;
    }

    public void setSignBrokerName(String signBrokerName) {
        this.signBrokerName = signBrokerName == null ? null : signBrokerName.trim();
    }

    public Date getSignBrokerTime() {
        return signBrokerTime;
    }

    public void setSignBrokerTime(Date signBrokerTime) {
        this.signBrokerTime = signBrokerTime;
    }

    public Integer getHurryStatus() {
        return hurryStatus;
    }

    public void setHurryStatus(Integer hurryStatus) {
        this.hurryStatus = hurryStatus;
    }

    public Date getHurryTime() {
        return hurryTime;
    }

    public void setHurryTime(Date hurryTime) {
        this.hurryTime = hurryTime;
    }

    public Integer getFocusStatus() {
        return focusStatus;
    }

    public void setFocusStatus(Integer focusStatus) {
        this.focusStatus = focusStatus;
    }

    public Date getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Date focusTime) {
        this.focusTime = focusTime;
    }

    public Integer getSpecialStatus() {
        return specialStatus;
    }

    public void setSpecialStatus(Integer specialStatus) {
        this.specialStatus = specialStatus;
    }

    public Date getSpecialTime() {
        return specialTime;
    }

    public void setSpecialTime(Date specialTime) {
        this.specialTime = specialTime;
    }

    public Integer getPauseStatus() {
        return pauseStatus;
    }

    public void setPauseStatus(Integer pauseStatus) {
        this.pauseStatus = pauseStatus;
    }

    public Date getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(Date pauseTime) {
        this.pauseTime = pauseTime;
    }

    public Integer getInvalidStatus() {
        return invalidStatus;
    }

    public void setInvalidStatus(Integer invalidStatus) {
        this.invalidStatus = invalidStatus;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Integer getSerialStatus() {
        return serialStatus;
    }

    public void setSerialStatus(Integer serialStatus) {
        this.serialStatus = serialStatus;
    }

    public Date getSerialTime() {
        return serialTime;
    }

    public void setSerialTime(Date serialTime) {
        this.serialTime = serialTime;
    }

    public Integer getOverdueWarnStatus() {
        return overdueWarnStatus;
    }

    public void setOverdueWarnStatus(Integer overdueWarnStatus) {
        this.overdueWarnStatus = overdueWarnStatus;
    }

    public Date getOverdueWarnTime() {
        return overdueWarnTime;
    }

    public void setOverdueWarnTime(Date overdueWarnTime) {
        this.overdueWarnTime = overdueWarnTime;
    }

    public Long getUpdatedUcid() {
        return updatedUcid;
    }

    public void setUpdatedUcid(Long updatedUcid) {
        this.updatedUcid = updatedUcid;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getIsLimitBuy() {
        return isLimitBuy;
    }

    public void setIsLimitBuy(String isLimitBuy) {
        this.isLimitBuy = isLimitBuy == null ? null : isLimitBuy.trim();
    }

    public String getHouseUsage() {
        return houseUsage;
    }

    public void setHouseUsage(String houseUsage) {
        this.houseUsage = houseUsage == null ? null : houseUsage.trim();
    }

    public Integer getFastBrokerType() {
        return fastBrokerType;
    }

    public void setFastBrokerType(Integer fastBrokerType) {
        this.fastBrokerType = fastBrokerType;
    }

    public Integer getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Integer officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getAddResource() {
        return addResource;
    }

    public void setAddResource(String addResource) {
        this.addResource = addResource == null ? null : addResource.trim();
    }

    public String getDelSourceSup() {
        return delSourceSup;
    }

    public void setDelSourceSup(String delSourceSup) {
        this.delSourceSup = delSourceSup == null ? null : delSourceSup.trim();
    }

    public String getDelSourceSub() {
        return delSourceSub;
    }

    public void setDelSourceSub(String delSourceSub) {
        this.delSourceSub = delSourceSub == null ? null : delSourceSub.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerWeixin() {
        return ownerWeixin;
    }

    public void setOwnerWeixin(String ownerWeixin) {
        this.ownerWeixin = ownerWeixin == null ? null : ownerWeixin.trim();
    }

    public String getOwnerMobilePhone1() {
        return ownerMobilePhone1;
    }

    public void setOwnerMobilePhone1(String ownerMobilePhone1) {
        this.ownerMobilePhone1 = ownerMobilePhone1 == null ? null : ownerMobilePhone1.trim();
    }

    public String getOwnerMobilePhone2() {
        return ownerMobilePhone2;
    }

    public void setOwnerMobilePhone2(String ownerMobilePhone2) {
        this.ownerMobilePhone2 = ownerMobilePhone2 == null ? null : ownerMobilePhone2.trim();
    }

    public String getOwnerHomePhone() {
        return ownerHomePhone;
    }

    public void setOwnerHomePhone(String ownerHomePhone) {
        this.ownerHomePhone = ownerHomePhone == null ? null : ownerHomePhone.trim();
    }

    public String getLinkerOtherName() {
        return linkerOtherName;
    }

    public void setLinkerOtherName(String linkerOtherName) {
        this.linkerOtherName = linkerOtherName == null ? null : linkerOtherName.trim();
    }

    public String getLinkerOtherMobilePhone() {
        return linkerOtherMobilePhone;
    }

    public void setLinkerOtherMobilePhone(String linkerOtherMobilePhone) {
        this.linkerOtherMobilePhone = linkerOtherMobilePhone == null ? null : linkerOtherMobilePhone.trim();
    }

    public String getLinkerOtherRelation() {
        return linkerOtherRelation;
    }

    public void setLinkerOtherRelation(String linkerOtherRelation) {
        this.linkerOtherRelation = linkerOtherRelation == null ? null : linkerOtherRelation.trim();
    }

    public String getApproTime() {
        return approTime;
    }

    public void setApproTime(String approTime) {
        this.approTime = approTime == null ? null : approTime.trim();
    }

    public Long getOrdinaryBrokerUcid() {
        return ordinaryBrokerUcid;
    }

    public void setOrdinaryBrokerUcid(Long ordinaryBrokerUcid) {
        this.ordinaryBrokerUcid = ordinaryBrokerUcid;
    }

    public String getOrdinaryBrokerName() {
        return ordinaryBrokerName;
    }

    public void setOrdinaryBrokerName(String ordinaryBrokerName) {
        this.ordinaryBrokerName = ordinaryBrokerName == null ? null : ordinaryBrokerName.trim();
    }

    public String getOrdinaryBrokerOrgCode() {
        return ordinaryBrokerOrgCode;
    }

    public void setOrdinaryBrokerOrgCode(String ordinaryBrokerOrgCode) {
        this.ordinaryBrokerOrgCode = ordinaryBrokerOrgCode == null ? null : ordinaryBrokerOrgCode.trim();
    }

    public String getOrdinaryBrokerRole() {
        return ordinaryBrokerRole;
    }

    public void setOrdinaryBrokerRole(String ordinaryBrokerRole) {
        this.ordinaryBrokerRole = ordinaryBrokerRole == null ? null : ordinaryBrokerRole.trim();
    }

    public Date getOrdinaryBrokerTime() {
        return ordinaryBrokerTime;
    }

    public void setOrdinaryBrokerTime(Date ordinaryBrokerTime) {
        this.ordinaryBrokerTime = ordinaryBrokerTime;
    }

    public String getMsgCheck() {
        return msgCheck;
    }

    public void setMsgCheck(String msgCheck) {
        this.msgCheck = msgCheck == null ? null : msgCheck.trim();
    }

    public Integer getIsPool() {
        return isPool;
    }

    public void setIsPool(Integer isPool) {
        this.isPool = isPool;
    }

    public Date getDelGradeTime() {
        return delGradeTime;
    }

    public void setDelGradeTime(Date delGradeTime) {
        this.delGradeTime = delGradeTime;
    }

    public Boolean getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(Boolean loginClient) {
        this.loginClient = loginClient;
    }

    public BigDecimal getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }

    public String getHighUnitPriceReason() {
        return highUnitPriceReason;
    }

    public void setHighUnitPriceReason(String highUnitPriceReason) {
        this.highUnitPriceReason = highUnitPriceReason == null ? null : highUnitPriceReason.trim();
    }

    public Float getInventoryScore() {
        return inventoryScore;
    }

    public void setInventoryScore(Float inventoryScore) {
        this.inventoryScore = inventoryScore;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Date getPriceUpdateTime() {
        return priceUpdateTime;
    }

    public void setPriceUpdateTime(Date priceUpdateTime) {
        this.priceUpdateTime = priceUpdateTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("housedelCode", housedelCode)
                .add("delType", delType)
                .add("delStatus", delStatus)
                .add("twoDimension", twoDimension)
                .add("houseId", houseId)
                .add("standardHouseId", standardHouseId)
                .add("price", price)
                .add("priceChangeType", priceChangeType)
                .add("delGrade", delGrade)
                .add("gradeReason", gradeReason)
                .add("saleReason", saleReason)
                .add("isIntercommunity", isIntercommunity)
                .add("isUnique", isUnique)
                .add("guarantyInfo", guarantyInfo)
                .add("guarantyMoney", guarantyMoney)
                .add("guarantyBank", guarantyBank)
                .add("guarantyRepayType", guarantyRepayType)
                .add("residenceStatus", residenceStatus)
                .add("marriage", marriage)
                .add("purchasePrice", purchasePrice)
                .add("paymentMode", paymentMode)
                .add("guidePrice", guidePrice)
                .add("registerTime", registerTime)
                .add("registerPhoto", registerPhoto)
                .add("purchaseTime", purchaseTime)
                .add("purchasePhoto", purchasePhoto)
                .add("deedTime", deedTime)
                .add("deedPhoto", deedPhoto)
                .add("rentType", rentType)
                .add("rentDeadline", rentDeadline)
                .add("rentPayWay", rentPayWay)
                .add("rentFacility", rentFacility)
                .add("houseStatus", houseStatus)
                .add("rentEndDate", rentEndDate)
                .add("rentNamePhone", rentNamePhone)
                .add("statusRemark", statusRemark)
                .add("fitmentStatus", fitmentStatus)
                .add("specialRemark", specialRemark)
                .add("creatorUcid", creatorUcid)
                .add("creatorName", creatorName)
                .add("creatorOrgCode", creatorOrgCode)
                .add("creatorRole", creatorRole)
                .add("createdTime", createdTime)
                .add("holderUcid", holderUcid)
                .add("holderName", holderName)
                .add("holderOrgCode", holderOrgCode)
                .add("holderRole", holderRole)
                .add("holderTime", holderTime)
                .add("approBrokerUcid", approBrokerUcid)
                .add("approBrokerName", approBrokerName)
                .add("approBrokerOrgCode", approBrokerOrgCode)
                .add("approBrokerRole", approBrokerRole)
                .add("approBrokerTime", approBrokerTime)
                .add("keyBrokerUcid", keyBrokerUcid)
                .add("keyBrokerName", keyBrokerName)
                .add("keyBrokerOrgCode", keyBrokerOrgCode)
                .add("keyBrokerRole", keyBrokerRole)
                .add("keyBrokerTime", keyBrokerTime)
                .add("fastBrokerUcid", fastBrokerUcid)
                .add("fastBrokerName", fastBrokerName)
                .add("fastBrokerOrgCode", fastBrokerOrgCode)
                .add("fastBrokerRole", fastBrokerRole)
                .add("fastBrokerTime", fastBrokerTime)
                .add("signBrokerUcid", signBrokerUcid)
                .add("signBrokerName", signBrokerName)
                .add("signBrokerTime", signBrokerTime)
                .add("hurryStatus", hurryStatus)
                .add("hurryTime", hurryTime)
                .add("focusStatus", focusStatus)
                .add("focusTime", focusTime)
                .add("specialStatus", specialStatus)
                .add("specialTime", specialTime)
                .add("pauseStatus", pauseStatus)
                .add("pauseTime", pauseTime)
                .add("invalidStatus", invalidStatus)
                .add("invalidTime", invalidTime)
                .add("serialStatus", serialStatus)
                .add("serialTime", serialTime)
                .add("overdueWarnStatus", overdueWarnStatus)
                .add("overdueWarnTime", overdueWarnTime)
                .add("updatedUcid", updatedUcid)
                .add("updatedName", updatedName)
                .add("updatedTime", updatedTime)
                .add("isLimitBuy", isLimitBuy)
                .add("houseUsage", houseUsage)
                .add("fastBrokerType", fastBrokerType)
                .add("officeAddress", officeAddress)
                .add("addResource", addResource)
                .add("delSourceSup", delSourceSup)
                .add("delSourceSub", delSourceSub)
                .add("ownerName", ownerName)
                .add("ownerWeixin", ownerWeixin)
                .add("ownerMobilePhone1", ownerMobilePhone1)
                .add("ownerMobilePhone2", ownerMobilePhone2)
                .add("ownerHomePhone", ownerHomePhone)
                .add("linkerOtherName", linkerOtherName)
                .add("linkerOtherMobilePhone", linkerOtherMobilePhone)
                .add("linkerOtherRelation", linkerOtherRelation)
                .add("approTime", approTime)
                .add("ordinaryBrokerUcid", ordinaryBrokerUcid)
                .add("ordinaryBrokerName", ordinaryBrokerName)
                .add("ordinaryBrokerOrgCode", ordinaryBrokerOrgCode)
                .add("ordinaryBrokerRole", ordinaryBrokerRole)
                .add("ordinaryBrokerTime", ordinaryBrokerTime)
                .add("msgCheck", msgCheck)
                .add("isPool", isPool)
                .add("delGradeTime", delGradeTime)
                .add("loginClient", loginClient)
                .add("buildArea", buildArea)
                .add("highUnitPriceReason", highUnitPriceReason)
                .add("inventoryScore", inventoryScore)
                .add("voteCount", voteCount)
                .add("priceUpdateTime", priceUpdateTime)
                .toString();
    }
}