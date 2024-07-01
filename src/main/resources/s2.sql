Hibernate:
selectuser0_.id as id1_6_0_,address2_.id as id1_0_1_,orders3_.id as id1_2_2_,user0_.date_create as date_cre2_6_0_,user0_.date_last_update_data as date_las3_6_0_,user0_.email as email4_6_0_,user0_.first_name as first_na5_6_0_,user0_.last_name as last_nam6_6_0_,user0_.name as name7_6_0_, user0_.phone as phone8_6_0_,user0_.two_factor_auth_type as two_fact9_6_0_,user0_.two_factor_auth_type_enable as two_fac10_6_0_,address2_.city as city2_0_1_,address2_.state as state3_0_1_,address2_.street as street4_0_1_,address2_.zip_code as zip_code5_0_1_,addresses1_.user_id as user_id1_7_0__,addresses1_.addresses_id as addresse2_7_0__,orders3_.address_id as address_6_2_2_,orders3_.customer_id as customer7_2_2_,orders3_.date_create as date_cre2_2_2_,orders3_.date_last_update_status as date_las3_2_2_,orders3_.price as price4_2_2_,orders3_.status as status5_2_2_,orders3_.customer_id as customer7_2_1__,orders3_.id as id1_2_1__
from il_user user0_
left outer join il_user_addresses addresses1_ on user0_.id=addresses1_.user_id
left outer join il_address address2_ on addresses1_.addresses_id=address2_.id
left outer join il_order orders3_ on user0_.id=orders3_.customer_id
offset 100 limit 20
