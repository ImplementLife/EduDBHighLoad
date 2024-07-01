Hibernate:
select
    items0_.order_id as order_id4_3_0_,
    items0_.id as id1_3_0_,
    items0_.id as id1_3_1_,
    items0_.order_id as order_id4_3_1_,
    items0_.price as price2_3_1_,
    items0_.product_id as product_5_3_1_,
    items0_.quantity as quantity3_3_1_,
    product1_.id as id1_4_2_,
    product1_.category_id as category5_4_2_,
    product1_.description as descript2_4_2_,
    product1_.name as name3_4_2_,
    product1_.price as price4_4_2_,
    category2_.id as id1_1_3_,
    category2_.description as descript2_1_3_,
    category2_.name as name3_1_3_
from il_order_item items0_
left outer join il_product product1_ on items0_.product_id=product1_.id
left outer join il_category category2_ on product1_.category_id=category2_.id
where items0_.order_id=?