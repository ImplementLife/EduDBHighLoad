Hibernate:
select order0_.id as id1_2_0_, order0_.address_id as address_6_2_0_, order0_.customer_id as customer7_2_0_, order0_.date_create as date_cre2_2_0_, order0_.date_last_update_status as date_las3_2_0_, order0_.price as price4_2_0_, order0_.status as status5_2_0_, address1_.id as id1_0_1_, address1_.city as city2_0_1_, address1_.state as state3_0_1_, address1_.street as street4_0_1_, address1_.zip_code as zip_code5_0_1_, user2_.id as id1_6_2_, user2_.date_create as date_cre2_6_2_, user2_.date_last_update_data as date_las3_6_2_, user2_.email as email4_6_2_, user2_.first_name as first_na5_6_2_, user2_.last_name as last_nam6_6_2_, user2_.name as name7_6_2_, user2_.phone as phone8_6_2_, user2_.two_factor_auth_type as two_fact9_6_2_, user2_.two_factor_auth_type_enable as two_fac10_6_2_, items3_.order_id as order_id4_3_3_, items3_.id as id1_3_3_, items3_.id as id1_3_4_, items3_.order_id as order_id4_3_4_, items3_.price as price2_3_4_, items3_.product_id as product_5_3_4_, items3_.quantity as quantity3_3_4_, product4_.id as id1_4_5_, product4_.category_id as category5_4_5_, product4_.description as descript2_4_5_, product4_.name as name3_4_5_, product4_.price as price4_4_5_, category5_.id as id1_1_6_, category5_.description as descript2_1_6_, category5_.name as name3_1_6_
from il_order order0_
left outer join il_address address1_ on order0_.address_id=address1_.id
left outer join il_user user2_ on order0_.customer_id=user2_.id
left outer join il_order_item items3_ on order0_.id=items3_.order_id
left outer join il_product product4_ on items3_.product_id=product4_.id
left outer join il_category category5_ on product4_.category_id=category5_.id
where order0_.id=?


Hibernate:
select user0_.id as id1_6_0_, address2_.id as id1_0_1_, orders3_.id as id1_2_2_, user0_.date_create as date_cre2_6_0_, user0_.date_last_update_data as date_las3_6_0_, user0_.email as email4_6_0_, user0_.first_name as first_na5_6_0_, user0_.last_name as last_nam6_6_0_, user0_.name as name7_6_0_, user0_.phone as phone8_6_0_, user0_.two_factor_auth_type as two_fact9_6_0_, user0_.two_factor_auth_type_enable as two_fac10_6_0_, address2_.city as city2_0_1_, address2_.state as state3_0_1_, address2_.street as street4_0_1_, address2_.zip_code as zip_code5_0_1_, addresses1_.user_id as user_id1_7_0__, addresses1_.addresses_id as addresse2_7_0__, orders3_.address_id as address_6_2_2_, orders3_.customer_id as customer7_2_2_, orders3_.date_create as date_cre2_2_2_, orders3_.date_last_update_status as date_las3_2_2_, orders3_.price as price4_2_2_, orders3_.status as status5_2_2_, orders3_.customer_id as customer7_2_1__, orders3_.id as id1_2_1__
from il_user user0_
left outer join il_user_addresses addresses1_ on user0_.id=addresses1_.user_id
left outer join il_address address2_ on addresses1_.addresses_id=address2_.id
left outer join il_order orders3_ on user0_.id=orders3_.customer_id
where user0_.id=?

Hibernate:
select user0_.id as id1_6_0_,address2_.id as id1_0_1_,orders3_.id as id1_2_2_,user0_.date_create as date_cre2_6_0_,user0_.date_last_update_data as date_las3_6_0_,user0_.email as email4_6_0_,user0_.first_name as first_na5_6_0_,user0_.last_name as last_nam6_6_0_,user0_.name as name7_6_0_, user0_.phone as phone8_6_0_,user0_.two_factor_auth_type as two_fact9_6_0_,user0_.two_factor_auth_type_enable as two_fac10_6_0_,address2_.city as city2_0_1_,address2_.state as state3_0_1_,address2_.street as street4_0_1_,address2_.zip_code as zip_code5_0_1_,addresses1_.user_id as user_id1_7_0__,addresses1_.addresses_id as addresse2_7_0__,orders3_.address_id as address_6_2_2_,orders3_.customer_id as customer7_2_2_,orders3_.date_create as date_cre2_2_2_,orders3_.date_last_update_status as date_las3_2_2_,orders3_.price as price4_2_2_,orders3_.status as status5_2_2_,orders3_.customer_id as customer7_2_1__,orders3_.id as id1_2_1__
from il_user user0_
left outer join il_user_addresses addresses1_ on user0_.id=addresses1_.user_id
left outer join il_address address2_ on addresses1_.addresses_id=address2_.id
left outer join il_order orders3_ on user0_.id=orders3_.customer_id
offset 100 limit 20;

Hibernate:
select user0_.id as id1_6_0_, address2_.id as id1_0_1_, orders3_.id as id1_2_2_, user0_.date_create as date_cre2_6_0_, user0_.date_last_update_data as date_las3_6_0_, user0_.email as email4_6_0_, user0_.first_name as first_na5_6_0_, user0_.last_name as last_nam6_6_0_, user0_.name as name7_6_0_, user0_.phone as phone8_6_0_, user0_.two_factor_auth_type as two_fact9_6_0_, user0_.two_factor_auth_type_enable as two_fac10_6_0_, address2_.city as city2_0_1_, address2_.state as state3_0_1_, address2_.street as street4_0_1_, address2_.zip_code as zip_code5_0_1_, addresses1_.user_id as user_id1_7_0__, addresses1_.addresses_id as addresse2_7_0__, orders3_.address_id as address_6_2_2_, orders3_.customer_id as customer7_2_2_, orders3_.date_create as date_cre2_2_2_, orders3_.date_last_update_status as date_las3_2_2_, orders3_.price as price4_2_2_, orders3_.status as status5_2_2_, orders3_.customer_id as customer7_2_1__, orders3_.id as id1_2_1__
from il_user user0_
left outer join il_user_addresses addresses1_ on user0_.id=addresses1_.user_id
left outer join il_address address2_ on addresses1_.addresses_id=address2_.id
left outer join il_order orders3_ on user0_.id=orders3_.customer_id
where user0_.id=?

Hibernate:
select
order0_.id as id1_2_0_,
order0_.address_id as address_6_2_0_,
order0_.customer_id as customer7_2_0_,
order0_.date_create as date_cre2_2_0_,
order0_.date_last_update_status as date_las3_2_0_,
order0_.price as price4_2_0_,
order0_.status as status5_2_0_
from il_order order0_
where order0_.id=?


Hibernate:
select user0_.id as id1_6_0_, orders1_.id as id1_2_1_, items2_.id as id1_3_2_, product3_.id as id1_4_3_, category4_.id as id1_1_4_, address6_.id as id1_0_5_, user0_.date_create as date_cre2_6_0_, user0_.date_last_update_data as date_las3_6_0_, user0_.email as email4_6_0_, user0_.first_name as first_na5_6_0_, user0_.last_name as last_nam6_6_0_, user0_.name as name7_6_0_, user0_.phone as phone8_6_0_, user0_.two_factor_auth_type as two_fact9_6_0_, user0_.two_factor_auth_type_enable as two_fac10_6_0_, orders1_.address_id as address_6_2_1_, orders1_.customer_id as customer7_2_1_, orders1_.date_create as date_cre2_2_1_, orders1_.date_last_update_status as date_las3_2_1_, orders1_.price as price4_2_1_, orders1_.status as status5_2_1_, orders1_.customer_id as customer7_2_0__, orders1_.id as id1_2_0__, items2_.order_id as order_id4_3_2_, items2_.price as price2_3_2_, items2_.product_id as product_5_3_2_, items2_.quantity as quantity3_3_2_, items2_.order_id as order_id4_3_1__, items2_.id as id1_3_1__, product3_.category_id as category5_4_3_, product3_.description as descript2_4_3_, product3_.name as name3_4_3_, product3_.price as price4_4_3_, category4_.description as descript2_1_4_, category4_.name as name3_1_4_, address6_.city as city2_0_5_, address6_.state as state3_0_5_, address6_.street as street4_0_5_, address6_.zip_code as zip_code5_0_5_, addresses5_.user_id as user_id1_7_2__, addresses5_.addresses_id as addresse2_7_2__
from il_user user0_
left outer join il_order orders1_ on user0_.id=orders1_.customer_id
left outer join il_order_item items2_ on orders1_.id=items2_.order_id
left outer join il_product product3_ on items2_.product_id=product3_.id
left outer join il_category category4_ on product3_.category_id=category4_.id
left outer join il_user_addresses addresses5_ on user0_.id=addresses5_.user_id
left outer join il_address address6_ on addresses5_.addresses_id=address6_.id
where user0_.id>? or user0_.id<?

Hibernate: select user0_.id as id1_6_0_, orders1_.id as id1_2_1_, items2_.id as id1_3_2_, address4_.id as id1_0_3_, user0_.date_create as date_cre2_6_0_, user0_.date_last_update_data as date_las3_6_0_, user0_.email as email4_6_0_, user0_.first_name as first_na5_6_0_, user0_.last_name as last_nam6_6_0_, user0_.name as name7_6_0_, user0_.phone as phone8_6_0_, user0_.two_factor_auth_type as two_fact9_6_0_, user0_.two_factor_auth_type_enable as two_fac10_6_0_, orders1_.address_id as address_6_2_1_, orders1_.customer_id as customer7_2_1_, orders1_.date_create as date_cre2_2_1_, orders1_.date_last_update_status as date_las3_2_1_, orders1_.price as price4_2_1_, orders1_.status as status5_2_1_, orders1_.customer_id as customer7_2_0__, orders1_.id as id1_2_0__, items2_.order_id as order_id4_3_2_, items2_.price as price2_3_2_, items2_.product_id as product_5_3_2_, items2_.quantity as quantity3_3_2_, items2_.order_id as order_id4_3_1__, items2_.id as id1_3_1__, address4_.city as city2_0_3_, address4_.state as state3_0_3_, address4_.street as street4_0_3_, address4_.zip_code as zip_code5_0_3_, addresses3_.user_id as user_id1_7_2__, addresses3_.addresses_id as addresse2_7_2__
from il_user user0_
left outer join il_order orders1_ on user0_.id=orders1_.customer_id
left outer join il_order_item items2_ on orders1_.id=items2_.order_id
left outer join il_user_addresses addresses3_ on user0_.id=addresses3_.user_id
left outer join il_address address4_ on addresses3_.addresses_id=address4_.id
where user0_.id>? or user0_.id<?

Hibernate:
select user0_.id as id1_6_0_, address2_.id as id1_0_1_, orders3_.id as id1_2_2_, address4_.id as id1_0_3_, items5_.id as id1_3_4_, user0_.date_create as date_cre2_6_0_, user0_.date_last_update_data as date_las3_6_0_, user0_.email as email4_6_0_, user0_.first_name as first_na5_6_0_, user0_.last_name as last_nam6_6_0_, user0_.name as name7_6_0_, user0_.phone as phone8_6_0_, user0_.two_factor_auth_type as two_fact9_6_0_, user0_.two_factor_auth_type_enable as two_fac10_6_0_, address2_.city as city2_0_1_, address2_.state as state3_0_1_, address2_.street as street4_0_1_, address2_.zip_code as zip_code5_0_1_, addresses1_.user_id as user_id1_7_0__, addresses1_.addresses_id as addresse2_7_0__, orders3_.address_id as address_6_2_2_, orders3_.customer_id as customer7_2_2_, orders3_.date_create as date_cre2_2_2_, orders3_.date_last_update_status as date_las3_2_2_, orders3_.price as price4_2_2_, orders3_.status as status5_2_2_, orders3_.customer_id as customer7_2_1__, orders3_.id as id1_2_1__, address4_.city as city2_0_3_, address4_.state as state3_0_3_, address4_.street as street4_0_3_, address4_.zip_code as zip_code5_0_3_, items5_.order_id as order_id4_3_4_, items5_.price as price2_3_4_, items5_.product_id as product_5_3_4_, items5_.quantity as quantity3_3_4_, items5_.order_id as order_id4_3_2__, items5_.id as id1_3_2__
from il_user user0_
left outer join il_user_addresses addresses1_ on user0_.id=addresses1_.user_id
left outer join il_address address2_ on addresses1_.addresses_id=address2_.id
left outer join il_order orders3_ on user0_.id=orders3_.customer_id
left outer join il_address address4_ on orders3_.address_id=address4_.id
left outer join il_order_item items5_ on orders3_.id=items5_.order_id
where user0_.id>? or user0_.id<?



