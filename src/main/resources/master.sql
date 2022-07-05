INSERT INTO `demo_springjwt`.`t_permission` (`permission_key`, `permission_name`) VALUES
 ('USER_CREATE', 'tạo user'), ('USER_READ','xem user'), ('USER_UPDATE', 'sửa user'), ('USER_DELETE', 'xóa user');
INSERT INTO `demo_springjwt`.`t_role` (`role_key`, `role_name`) VALUES
 ('ADMIN', 'Supper User'), ('CUSTOMER', 'Khách');
INSERT INTO `demo_springjwt`.`t_user` (`username`, `password`) VALUES
 ('hunglk', '$2a$10$VObHxmxycf0.QJNXlwqEc.mFZ.iYkS5V4zAJ0xdIMSoEYoW18O7cu'); -- hunglk/123456
INSERT INTO `demo_springjwt`.`t_role_permission` (`role_id`, `permission_id`) VALUES
 (1, 1), (1, 2), (1, 3), (1, 4);
INSERT INTO `demo_springjwt`.`t_user_role` (`user_id`, `role_id`) VALUES
 (1, 1);