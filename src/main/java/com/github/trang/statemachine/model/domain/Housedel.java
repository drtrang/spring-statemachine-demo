package com.github.trang.statemachine.model.domain;

import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Accessors(fluent = true)
@Getter @Setter
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