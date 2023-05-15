package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearningVideoVo {
        /**
         *
         */

        /**
         *
         */
        private String label;

        /**
         *
         */
        private Long parent;

        /**
         *
         */

        private String videourl;

        List<LearningVideoVo> children;

        @TableField(exist = false)
        private static final long serialVersionUID = 1L;

}
