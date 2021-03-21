package com.lzq.interview;

/**
 * 跃盟科技
 * 查出来,阅读量最高的作者和文章
 *
 * @author lzq
 */
public class SqlReadMost {

//SELECT a.user_id,
//       a.id
//        FROM article a,
//        (SELECT
//        art.user_id,
//                MAX(art.read_num)
//        FROM article art GROUP BY art.user_id) b
//        WHERE a.user_id = b.user_id AND a.read_num=b.read_num
}
