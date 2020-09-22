package com.project.ischool.commodityservice.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author alancci
 * @since 2020-09-22
 */
@ApiModel(value="Commodity对象", description="")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "卖家id")
    private Integer userId;

    @ApiModelProperty(value = "商品类别")
    private String commodityCategory;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "是否审核0否1是")
    private Integer isChecked;

    @ApiModelProperty(value = "是否有效，1有效，0无效")
    private Integer isEffected;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getCommodityCategory() {
        return commodityCategory;
    }

    public void setCommodityCategory(String commodityCategory) {
        this.commodityCategory = commodityCategory;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }
    public Integer getIsEffected() {
        return isEffected;
    }

    public void setIsEffected(Integer isEffected) {
        this.isEffected = isEffected;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Commodity{" +
            "id=" + id +
            ", userId=" + userId +
            ", commodityCategory=" + commodityCategory +
            ", phone=" + phone +
            ", content=" + content +
            ", image=" + image +
            ", title=" + title +
            ", isChecked=" + isChecked +
            ", isEffected=" + isEffected +
            ", createTime=" + createTime +
        "}";
    }
}
