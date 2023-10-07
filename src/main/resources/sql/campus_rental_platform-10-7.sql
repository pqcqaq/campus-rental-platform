/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012 (8.0.12)
 Source Host           : localhost:33060
 Source Schema         : campus_rental_platform

 Target Server Type    : MySQL
 Target Server Version : 80012 (8.0.12)
 File Encoding         : 65001

 Date: 07/10/2023 23:00:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment`
(
    `id`                bigint(20)                                                     NOT NULL AUTO_INCREMENT,
    `original_filename` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `server_path`       varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `md5`               varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `create_by`         bigint(20)                                                     NOT NULL,
    `create_time`       datetime                                                       NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1710438123433193474
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '上传的附件'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment`
VALUES (1709060796295192577, 'bYsk70oEcs6z7e541937108096fd9fe707210590ae94.png',
        'E:\\avatar\\1696306821319-1ddc5b0a-cba2-40e4-9dfb-ced9a52f3806.png', '7e541937108096fd9fe707210590ae94', 1,
        '2023-10-03 12:20:21');
INSERT INTO `attachment`
VALUES (1709060783720669185, 'twKYOzR99Wq7583cca8c1b16808b6e72330ff7f4bed5.jpg',
        'E:\\avatar\\1696306818299-134034cf-3db6-4c61-9648-fb1362e5ec2a.jpg', '583cca8c1b16808b6e72330ff7f4bed5', 1,
        '2023-10-03 12:20:18');
INSERT INTO `attachment`
VALUES (1709049677480501250, 'logo.png', 'E:\\avatar\\1696304170384-7865362a-53e8-4ab9-bebb-a98f3d29571e.png',
        'f73aa8b0c34f750c96cf42af71d76257', 1, '2023-10-03 11:36:10');
INSERT INTO `attachment`
VALUES (1709049653568774146, 'd4bc75f8ea484f2bd6175e695e6d9b4113424258 拷贝.jpg',
        'E:\\avatar\\1696304164684-34cbcade-1453-41e5-a6bd-b3b93ef33777.jpg', '719cd16997b4cea62118326415bece45', 1,
        '2023-10-03 11:36:05');
INSERT INTO `attachment`
VALUES (1709049607804723201, 'a8e5c3046778c406f8e91b11d152ff385a2f95ef.jpg',
        'E:\\avatar\\1696304153738-3b1c9118-4a48-437f-8433-91d58796bea0.jpg', '790c7cc1070b90f1ba17dbec3d3f9d21', 1,
        '2023-10-03 11:35:54');
INSERT INTO `attachment`
VALUES (1709060810086064130, 'BIpJT7zIAQYWc8b579f386a33eb19c46899a56b43a49.png',
        'E:\\avatar\\1696306824605-8e6e2ab3-224e-461c-940a-b197f3e0e6e9.png', 'c8b579f386a33eb19c46899a56b43a49', 1,
        '2023-10-03 12:20:25');
INSERT INTO `attachment`
VALUES (1709066279122935809, 'logo 拷贝.png', 'E:\\avatar\\1696308128521-6f1ab3c1-bd54-40d2-9527-b8413163b913.png',
        '60d4c6ee30d211e21343bbeb2b06041f', 1, '2023-10-03 12:42:09');
INSERT INTO `attachment`
VALUES (1709072951899889666, 'QQ截图20230110130842.png',
        'E:\\avatar\\1696309719432-a20e6df0-abfb-4b4d-8a09-d37de799c670.png', '280a67e531762cfa756043fb9f2e04e0', 1,
        '2023-10-03 13:08:39');
INSERT INTO `attachment`
VALUES (1709073281232445442, 'logo 拷贝.jpg', 'E:\\avatar\\1696309797946-703c1eef-9213-434c-8b73-9d542f329c91.jpg',
        '3e78ab988119a91fc4dbd1bb9503d04d', 1, '2023-10-03 13:09:58');
INSERT INTO `attachment`
VALUES (1709098413397155842, 'IDEA LOGO.png', 'E:\\avatar\\1696315789924-73e62287-8375-46cb-8ad8-cbd99d63e26c.png',
        '98865e06d77faca32b3e118df119049e', 1, '2023-10-03 14:49:50');
INSERT INTO `attachment`
VALUES (1709153567739781122, 'QQ截图20230110131029.png',
        'E:\\avatar\\1696328939738-a21662cd-bea0-4a6d-bbbb-fa070abb4ef8.png', '37e1bf4ec1aa0b8d3b3bd787a4bfd126', 1,
        '2023-10-03 18:29:00');
INSERT INTO `attachment`
VALUES (1709400483459317761, 'VHkoYv9PIbvvd9ab9018b2f0e1f49939f2af50d158f4.jpg',
        'E:\\avatar\\2023-10-04/1696387809024-2412e52c-defd-4a8b-9056-2c09c994e482.jpg',
        'd9ab9018b2f0e1f49939f2af50d158f4', 1, '2023-10-04 10:50:09');
INSERT INTO `attachment`
VALUES (1709401009743806465, 'gCTx8IWS12OT9d2e6b25eb43b42b36cbc1ade2b36db3.png',
        'E:\\avatar\\2023-10-04/1696387934512-d48ffe12-2047-4b6f-9655-330148273770.png',
        '9d2e6b25eb43b42b36cbc1ade2b36db3', 1, '2023-10-04 10:52:15');
INSERT INTO `attachment`
VALUES (1709401561449971713, '5J3IKL3f0halb7909ed56964c1b59d9593c0f7719aeb.png',
        'E:\\avatar\\2023-10-04/1696388066044-b7a898aa-7859-4e48-8de1-2b5e5127e237.png',
        'b7909ed56964c1b59d9593c0f7719aeb', 1, '2023-10-04 10:54:26');
INSERT INTO `attachment`
VALUES (1709401561449971714, 'eFPZlEc2usEy119aee42aa669b892637daddf0e6517b.png',
        'E:\\avatar\\2023-10-04/1696388066052-028eb434-6010-4c59-a0ba-5c0f5368780e.png',
        '119aee42aa669b892637daddf0e6517b', 1, '2023-10-04 10:54:26');
INSERT INTO `attachment`
VALUES (1709402604812451842, 'q9NH5iEFwVYI1d99b450bb3faa225a688b1ff7b532cc.png',
        'E:\\avatar\\2023-10-04/1696388314813-c4803ff2-82e3-4333-a426-47edf0d62026.png',
        '1d99b450bb3faa225a688b1ff7b532cc', 1, '2023-10-04 10:58:35');
INSERT INTO `attachment`
VALUES (1709402605013778434, 'BnHJwmQ5Xljl5c79e0167d854f6b13965c402156b368.png',
        'E:\\avatar\\2023-10-04/1696388314852-6e22aaf8-20d3-43d7-a4f9-c73e4fc71641.png',
        '5c79e0167d854f6b13965c402156b368', 1, '2023-10-04 10:58:35');
INSERT INTO `attachment`
VALUES (1709402605013778435, 'y4StUDZrvxYKd1c128c21ffd5a24650d249e8cef8412.png',
        'E:\\avatar\\2023-10-04/1696388314861-0d5674a1-d874-4d75-a695-d70a89b0d07f.png',
        'd1c128c21ffd5a24650d249e8cef8412', 1, '2023-10-04 10:58:35');
INSERT INTO `attachment`
VALUES (1709402605080887297, 'CXNEnQmim49824d0eab005f4bac5e33bda66d1804b47.png',
        'E:\\avatar\\2023-10-04/1696388314873-f227f4fa-4b8f-4bac-a2c0-613e0b50247c.png',
        '24d0eab005f4bac5e33bda66d1804b47', 1, '2023-10-04 10:58:35');
INSERT INTO `attachment`
VALUES (1709402605143801858, '1TfVvn8ZdALi48e30a37ac2f642648f79e7fed7d4b93.png',
        'E:\\avatar\\2023-10-04/1696388314886-60a7dab0-0704-485e-930c-39b02e146f42.png',
        '48e30a37ac2f642648f79e7fed7d4b93', 1, '2023-10-04 10:58:35');
INSERT INTO `attachment`
VALUES (1709402702065778689, '9shvBeyYVEvzc5ffeec8287dec77c1a046148ec98a7c.png',
        'E:\\avatar\\2023-10-04/1696388337993-bd049990-8ea4-4fad-a11d-cc668c927472.png',
        'c5ffeec8287dec77c1a046148ec98a7c', 1, '2023-10-04 10:58:58');
INSERT INTO `attachment`
VALUES (1709402702065778690, 'MWROoYqpJDMc1f42516da143da1704666c907a76bc4d.png',
        'E:\\avatar\\2023-10-04/1696388338004-c893ce27-62c1-48ed-abe5-a8f2ad61f5d0.png',
        '1f42516da143da1704666c907a76bc4d', 1, '2023-10-04 10:58:58');
INSERT INTO `attachment`
VALUES (1709402702132887553, 'bT8nxS5qb9b36b2099bc7bff7ed6f603493673387d27.png',
        'E:\\avatar\\2023-10-04/1696388338018-e0387b42-2adb-45aa-9da9-ebc0ff935775.png',
        '6b2099bc7bff7ed6f603493673387d27', 1, '2023-10-04 10:58:58');
INSERT INTO `attachment`
VALUES (1709402702195802113, '4EzAOMU0YElcecb2f4a75f4f3cb4963279c4ad85ebb3.png',
        'E:\\avatar\\2023-10-04/1696388338030-2a445d22-df56-4348-bbdf-c2e0212534e7.png',
        'ecb2f4a75f4f3cb4963279c4ad85ebb3', 1, '2023-10-04 10:58:58');
INSERT INTO `attachment`
VALUES (1709402702262910977, 'p1sypYWDudnldc45773c5dc2020dca29241e004a2264.png',
        'E:\\avatar\\2023-10-04/1696388338046-2bc71431-2c37-40dd-8b4b-90db1391eabc.png',
        'dc45773c5dc2020dca29241e004a2264', 1, '2023-10-04 10:58:58');
INSERT INTO `attachment`
VALUES (1709402702455848961, 'WQhPpqvPMrl213c60bea62f333bcb5e53b16f2eb9c39.png',
        'E:\\avatar\\2023-10-04/1696388338100-9dadd376-c85b-43e1-a2fa-eb1a7ff825ae.png',
        '13c60bea62f333bcb5e53b16f2eb9c39', 1, '2023-10-04 10:58:58');
INSERT INTO `attachment`
VALUES (1709402725272862721, 'MSyqau3MBN1Yadff7406ec27d382fc9f0a2f6b40b549.png',
        'E:\\avatar\\2023-10-04/1696388343535-8e2287d0-e63b-44b9-8884-e60f24e9619c.png',
        'adff7406ec27d382fc9f0a2f6b40b549', 1, '2023-10-04 10:59:04');
INSERT INTO `attachment`
VALUES (1709402725335777282, 'QwWtW7la9A95502ff3fa9ecb3c72de3670edf508b7f8.jpg',
        'E:\\avatar\\2023-10-04/1696388343550-bcfc48a8-3f2a-44aa-b1cc-5f1d064c5234.jpg',
        '502ff3fa9ecb3c72de3670edf508b7f8', 1, '2023-10-04 10:59:04');
INSERT INTO `attachment`
VALUES (1709402725398691841, 'kibHk0tRGqG70594225b748ab62762764ce0bed3ca27.jpg',
        'E:\\avatar\\2023-10-04/1696388343562-5da48162-adc7-4b05-b718-0127e672e40c.jpg',
        '0594225b748ab62762764ce0bed3ca27', 1, '2023-10-04 10:59:04');
INSERT INTO `attachment`
VALUES (1709402851664019457, 'SqsD8V0gJb065ab51e908c09ee2ca9342928126b0b65.png',
        'E:\\avatar\\2023-10-04/1696388373659-97db4275-1f97-4903-8d4b-247478281130.png',
        '5ab51e908c09ee2ca9342928126b0b65', 1, '2023-10-04 10:59:34');
INSERT INTO `attachment`
VALUES (1709404178066522113, 'WM26esoVPevu7a78c834b8a38641be24420325b0f5c7.png',
        'E:\\avatar\\2023-10-04/1696388689897-8262ac99-0189-44d7-821f-50f237690440.png',
        '7a78c834b8a38641be24420325b0f5c7', 1, '2023-10-04 11:04:50');
INSERT INTO `attachment`
VALUES (1709405006554808322, 'NUh8BYWtHtBO951f18be1c29c148b115e7cce6304da0.jpg',
        'E:\\avatar\\2023-10-04/1696388887434-c6808cc1-8c9e-4d79-8a8d-c81b3a2345da.jpg',
        '951f18be1c29c148b115e7cce6304da0', 1, '2023-10-04 11:08:07');
INSERT INTO `attachment`
VALUES (1709405006684831745, 'H3hbaYUEQ3IV04b3cab1b7001d35b32f449e073acf0d.png',
        'E:\\avatar\\2023-10-04/1696388887443-b7d82e94-8fcf-45ea-a1f6-b50f936062ac.png',
        '04b3cab1b7001d35b32f449e073acf0d', 1, '2023-10-04 11:08:07');
INSERT INTO `attachment`
VALUES (1709409610319347713, 'AmMXfonYZhbc1ebb08ce506afaaabbdea77978f71865.png',
        'E:\\avatar\\2023-10-04/1696389985057-52d86ced-1d8a-4a60-aa83-eb3ac44646a7.png',
        '1ebb08ce506afaaabbdea77978f71865', 1, '2023-10-04 11:26:25');
INSERT INTO `attachment`
VALUES (1709409610449371137, '4DJ0VbbHScDI0c06aa765ccbdeb3dab3727fcb8b80e9.png',
        'E:\\avatar\\2023-10-04/1696389985077-d76acaa4-e200-4d13-bdde-06c427c7cec7.png',
        '0c06aa765ccbdeb3dab3727fcb8b80e9', 1, '2023-10-04 11:26:25');
INSERT INTO `attachment`
VALUES (1709409610449371138, 'Es708ZiMzR6q37a6081932ba5f3ef7c24850537d9c97.png',
        'E:\\avatar\\2023-10-04/1696389985085-4d52b842-98c6-4e77-a864-344f76d931c5.png',
        '37a6081932ba5f3ef7c24850537d9c97', 1, '2023-10-04 11:26:25');
INSERT INTO `attachment`
VALUES (1709409834219683842, 'tmp_9b2ed7c3c4f22ff740c4cfacc9e21bfa2eb921a5f9dcc368.jpg',
        'E:\\avatar\\2023-10-04/1696390038432-40d6c7c6-2c30-4e20-8323-d95ecf629d82.jpg',
        'bbfde8cc93c42af7cd5990cda5d81cad', 1, '2023-10-04 11:27:18');
INSERT INTO `attachment`
VALUES (1709409834219683843, 'tmp_f4d1a236aa8b267303a5879d5645b85fcb7445cea245f737.jpg',
        'E:\\avatar\\2023-10-04/1696390038441-32d6ad8a-c9ee-43c0-abca-fbc5c437bc55.jpg',
        '2279348be6674bc6d72391166f2f14e9', 1, '2023-10-04 11:27:18');
INSERT INTO `attachment`
VALUES (1709409834349707266, 'tmp_3a3f4a3c9b8115e519c239dea9bb553c72c27d2b15bd4561.jpg',
        'E:\\avatar\\2023-10-04/1696390038475-b13cb72c-6bfb-4b69-a88f-6128f2d9abd4.jpg',
        'ffd033b2a69f0fc83154e2702b71881c', 1, '2023-10-04 11:27:18');
INSERT INTO `attachment`
VALUES (1709409834416816129, 'tmp_358e6c527ca593f9d34eeff4db9c4b055b8aaca6131ff419.jpg',
        'E:\\avatar\\2023-10-04/1696390038476-912940f4-2d99-4fef-80e0-b7f849fc9c5c.jpg',
        '712fbea88b09e92cca50ebd04bce8778', 1, '2023-10-04 11:27:18');
INSERT INTO `attachment`
VALUES (1709409834416816130, 'tmp_2e7c1d733e3be415bf844f3b9d88102ea21968ec248b09a7.jpg',
        'E:\\avatar\\2023-10-04/1696390038485-96b28710-a9ed-4c6a-992e-b8d4a7880d1f.jpg',
        'a2d6bff70188489d0102730d8bb0c7b8', 1, '2023-10-04 11:27:18');
INSERT INTO `attachment`
VALUES (1709409834542645250, 'tmp_7241e331248de2f37a3fa09d18be1ffe605e147292ab94a0.jpg',
        'E:\\avatar\\2023-10-04/1696390038505-a5bacbb2-67c3-4987-8beb-235cbf1e127b.jpg',
        '385d7b063e6efb237bd60564f6b71292', 1, '2023-10-04 11:27:19');
INSERT INTO `attachment`
VALUES (1709409834609754113, 'tmp_3b6644b3bd763eeee5a3b20eecd59a5daec0019911ee4dff.jpg',
        'E:\\avatar\\2023-10-04/1696390038535-1548ee76-d8f5-4e9f-99b1-12522658ea9d.jpg',
        '3398efea3eb2dc2ddfb4a4b78fd1e85d', 1, '2023-10-04 11:27:19');
INSERT INTO `attachment`
VALUES (1709409834676862978, 'tmp_7b67db49fd3188ce2dc3d376f56bf1c49a566a20ce745b01.jpg',
        'E:\\avatar\\2023-10-04/1696390038548-aa92f56b-3805-4744-92cb-fbf09ec446cf.jpg',
        '56be5661463526c1841cd2dd5f5c51c5', 1, '2023-10-04 11:27:19');
INSERT INTO `attachment`
VALUES (1709409834676862979, 'tmp_0b12a89cb3615061dfdba47c0e9726f329761eb7fe43bf66.jpg',
        'E:\\avatar\\2023-10-04/1696390038550-a546e627-3fd8-4ea2-852b-3ab12281d041.jpg',
        '607b2e84cd8c4548de51dd73aba22ec3', 1, '2023-10-04 11:27:19');
INSERT INTO `attachment`
VALUES (1709409869015629825, 'tmp_b462eabe57b8fab1f082929dba42a60d370218962f6512da.jpg',
        'E:\\avatar\\2023-10-04/1696390046736-168b05fe-3cc0-49be-b856-f2ae63d82995.jpg',
        'a871be4c1906a7840e9e564198c9faf5', 1, '2023-10-04 11:27:27');
INSERT INTO `attachment`
VALUES (1709444058000351234, 'rNtF1dh7d18wf0633eceaeb2cd997866d86ee45eaf21.png',
        'E:\\avatar\\2023-10-04/1696398198015-683896d4-79c8-49b2-a2c0-25223b1ab779.png',
        'f0633eceaeb2cd997866d86ee45eaf21', 1, '2023-10-04 13:43:18');
INSERT INTO `attachment`
VALUES (1709447454258311169, 'tmp_58c304add7884483ee7f05f489a12e86b26077c3f9ce7a53.jpg',
        'E:\\avatar\\2023-10-04/1696399007746-25dc8148-168d-4345-af19-13d601e2e046.jpg',
        '53bccbc7c680d4030e0e4b1306e08362', 1, '2023-10-04 13:56:48');
INSERT INTO `attachment`
VALUES (1709447454258311170, 'tmp_b61be215baf943bdfff3d18cda50b23e93e2bcb60f097678.jpg',
        'E:\\avatar\\2023-10-04/1696399007753-d9b1f462-529c-4a19-8ddd-f1885e62e5d7.jpg',
        '998b66d0a958c1782395b91f19198a0f', 1, '2023-10-04 13:56:48');
INSERT INTO `attachment`
VALUES (1709447454312837122, 'tmp_e76505c4637694b398989558e212209cc2eee6fe577973a5.jpg',
        'E:\\avatar\\2023-10-04/1696399007759-e25ebd46-73ea-454a-9966-c8908a189754.jpg',
        'e3a86d2bde119e90c0f08b53a4f54d13', 1, '2023-10-04 13:56:48');
INSERT INTO `attachment`
VALUES (1709447454509969410, 'tmp_174a5f24bc37e0bc69ac3e974fef8701e1288a35e3a9b8c4.jpg',
        'E:\\avatar\\2023-10-04/1696399007808-d4e44497-72a0-4d71-8632-8d7e132ea9e8.jpg',
        '75383f61591c4bbd703eb0a10c6fd22f', 1, '2023-10-04 13:56:48');
INSERT INTO `attachment`
VALUES (1709447502501195778, 'tmp_27b6d329e8ff963b58494edad20909308807cd7de2454af5.jpg',
        'E:\\avatar\\2023-10-04/1696399019259-c0122d8b-446e-4bf7-8e69-5201f03135c5.jpg',
        '9ef2a167d20f19f051864afc97afd51a', 1, '2023-10-04 13:56:59');
INSERT INTO `attachment`
VALUES (1709447502568304641, 'tmp_66d6e8643f8f8511b2f73af097ff7bfc8ba626f77abcdb72.jpg',
        'E:\\avatar\\2023-10-04/1696399019275-2a3e565d-6d3b-4c71-94d0-69b14e2a0e9d.jpg',
        '0c68b73cc7b204ac3bd0cd37aeffb3f0', 1, '2023-10-04 13:56:59');
INSERT INTO `attachment`
VALUES (1709447502568304642, 'tmp_ec90c426ddbcd5ea0b99d4f80d2c5a35699d95f71ba6a19e.jpg',
        'E:\\avatar\\2023-10-04/1696399019277-f222fc43-052a-4fb1-ae2c-7f5e18efd020.jpg',
        '12af6252737cf5d98dfeb262859919e0', 1, '2023-10-04 13:56:59');
INSERT INTO `attachment`
VALUES (1709447534633758722, 'tmp_337515214cff8dcafa3e4b65983334bca85bf6af88fa1e9e.jpg',
        'E:\\avatar\\2023-10-04/1696399026906-f6364db3-d05d-44fa-b943-829e57c1d0ff.jpg',
        '238fb2187d876da8c15ba5f36caf3c85', 1, '2023-10-04 13:57:07');
INSERT INTO `attachment`
VALUES (1709447534633758723, 'tmp_eb057fffc83cfda25d222587851799d7f4f5d03e42459f30.jpg',
        'E:\\avatar\\2023-10-04/1696399026920-3e29b4bf-a59d-43f5-840f-a6c3df3bc570.jpg',
        '305bc7b2cea70ec09ff4aa702a746de3', 1, '2023-10-04 13:57:07');
INSERT INTO `attachment`
VALUES (1709447583640006658, 'tmp_1055ef0e0167f6cb956b72eb92e87205ce63b254711f9a14.jpg',
        'E:\\avatar\\2023-10-04/1696399038597-ec5a900d-23f5-4511-a4f3-3359953e5e2b.jpg',
        '53dc42da5eabef7691af1a2b7959e6a7', 1, '2023-10-04 13:57:19');
INSERT INTO `attachment`
VALUES (1709549532318216194, 'CnUmaHtXrEmDafe4a44eccaf989d03b9caf7a0ff3023.png',
        'E:\\avatar\\2023-10-04/1696423345067-bf4003a0-b7f2-4dcf-8b89-77054dec5472.png',
        'afe4a44eccaf989d03b9caf7a0ff3023', 1, '2023-10-04 20:42:25');
INSERT INTO `attachment`
VALUES (1709552005883834370, 'cT7A8K9mjPaV0a2663284daaf4fd076df602ddf33a75.png',
        'E:\\avatar\\2023-10-04/1696423934810-c43ba0f0-8af7-41be-ba53-5e4e31c6b816.png',
        '0a2663284daaf4fd076df602ddf33a75', 1, '2023-10-04 20:52:15');
INSERT INTO `attachment`
VALUES (1709552058610429954, 'UzIW3efE0Xzg781121bd27f5ad645b7835be8cc529a3.png',
        'E:\\avatar\\2023-10-04/1696423947370-868b77e7-fdbc-47ac-8bc3-f59644c78f08.png',
        '781121bd27f5ad645b7835be8cc529a3', 1, '2023-10-04 20:52:27');
INSERT INTO `attachment`
VALUES (1709552058610429955, 'Zs2PgUJhTUXZ366702b28b25462a0e3a65f244a29024.png',
        'E:\\avatar\\2023-10-04/1696423947382-fed6a0bb-4a2a-4c93-9562-4e3ffd136646.png',
        '366702b28b25462a0e3a65f244a29024', 1, '2023-10-04 20:52:27');
INSERT INTO `attachment`
VALUES (1709552059990355969, '2Jg3pnShoMjS7e7ee8d6d7b687c71355a3dbcf9bc435.png',
        'E:\\avatar\\2023-10-04/1696423947703-1a1c5c26-b41e-4d5a-bccc-f0d68d0da2c4.png',
        '7e7ee8d6d7b687c71355a3dbcf9bc435', 1, '2023-10-04 20:52:28');
INSERT INTO `attachment`
VALUES (1709569078877958145, 'iSDq2s1dZZbPc85e21509582824cd5ce12b914a49b18.png',
        'E:\\avatar\\2023-10-04/1696428005313-83cc9404-6c16-4a00-8f8b-938dd93f78ca.png',
        'c85e21509582824cd5ce12b914a49b18', 1, '2023-10-04 22:00:05');
INSERT INTO `attachment`
VALUES (1709576300349566977, 'tmp_953031b43bcf801789fd40059bdd185a76668a84c4183304.jpg',
        'E:\\avatar\\2023-10-04/1696429727056-99d7eb6e-3d41-454f-9160-48b861e69eb9.jpg',
        'b7a9a2b139fd7abe23e0e386a3e94640', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709576300349566978, 'tmp_717b37e652eeb0d37653bf98eeb21fb818c46b5a0cc1305f.jpg',
        'E:\\avatar\\2023-10-04/1696429727062-6f186585-c4b9-4a16-808b-0c22a4b8710e.jpg',
        '4be7c35541556b70a5216085fec97a14', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709576300349566979, 'tmp_04562d339be81edb19cbf7a83e8951d5e3ad496400e7258d.jpg',
        'E:\\avatar\\2023-10-04/1696429727064-8d28cd37-9166-4811-b6db-ad7aeb675f2e.jpg',
        '853600bca1e626d55fb786fbba4a54d7', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709576300416675842, 'tmp_2ed7ac0985bf0d2fdd2e4afaae23d830480b65f5ea309d51.jpg',
        'E:\\avatar\\2023-10-04/1696429727066-5167a6bb-2125-4fd9-bd1e-41f7f1303967.jpg',
        '72c3529409386d7f6689cc94c2c6b332', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709576300550893570, 'tmp_5546abe0acfafa142d4a0fcf56b2a30d5df88883bf473f00.jpg',
        'E:\\avatar\\2023-10-04/1696429727105-0366f2d2-78fa-4fcf-9ba3-f4ab203f534b.jpg',
        'e629de72693cded4ebca3adef02fade0', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709576300550893571, 'tmp_5f47fb6d1dc19405f999ec10a40422c45eff2c1d5f5c3c5e.jpg',
        'E:\\avatar\\2023-10-04/1696429727110-21bc8e10-4ce4-447e-a1e3-e2c47b54f94e.jpg',
        '3aef177da42823fdb604f09e851da0ad', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709576300550893572, 'tmp_22b6b1ee1b4b29ba1df576ca6567fb8cfb8d6b533811f2aa.jpg',
        'E:\\avatar\\2023-10-04/1696429727111-eeb3a50d-813a-41be-9677-1b745185019f.jpg',
        '9fc33da02b3b4360d0081e547c221fe5', 1, '2023-10-04 22:28:47');
INSERT INTO `attachment`
VALUES (1709589866167349250, '54tE1TChWHiV0241b7027199f0ca080a060b32ff0f3f.png',
        'E:\\avatar\\2023-10-04/1696432961401-5ca4ad55-c762-47f1-ba59-5da6029e5a81.png',
        '0241b7027199f0ca080a060b32ff0f3f', 1, '2023-10-04 23:22:41');
INSERT INTO `attachment`
VALUES (1709589866234458114, 'dBff8nmnOsL2154656addee3181a72703448e718bcae.png',
        'E:\\avatar\\2023-10-04/1696432961412-baf70121-d840-4605-a4eb-d5b0f312f3bf.png',
        '154656addee3181a72703448e718bcae', 1, '2023-10-04 23:22:41');
INSERT INTO `attachment`
VALUES (1709589866297372673, 'dGxNZNnsKVls227532e391d4163c7211a993d22da760.jpg',
        'E:\\avatar\\2023-10-04/1696432961426-637102ea-0147-48c5-81cf-d221850c9c65.jpg',
        '227532e391d4163c7211a993d22da760', 1, '2023-10-04 23:22:41');
INSERT INTO `attachment`
VALUES (1709589879811420161, 'tjDhOBPKv0jMdad8d18f1c471d9f94faa4f6b985c635.png',
        'E:\\avatar\\2023-10-04/1696432964650-c2029635-0560-41ab-a973-687725aa1953.png',
        'dad8d18f1c471d9f94faa4f6b985c635', 1, '2023-10-04 23:22:45');
INSERT INTO `attachment`
VALUES (1709589879878529026, 'FXHX0uN5FcVSa56404a254097f227959b366cd4a5f83.png',
        'E:\\avatar\\2023-10-04/1696432964670-389a4ab8-ee1b-47f2-8dc8-bde83e1a3203.png',
        'a56404a254097f227959b366cd4a5f83', 1, '2023-10-04 23:22:45');
INSERT INTO `attachment`
VALUES (1709589879941443586, 'aceLEhj5d9xN9a78867e8c82b6667722f695895606c6.png',
        'E:\\avatar\\2023-10-04/1696432964686-e380e1e6-3071-4733-8ceb-5a1f9a2dadfb.png',
        '9a78867e8c82b6667722f695895606c6', 1, '2023-10-04 23:22:45');
INSERT INTO `attachment`
VALUES (1709589880008552450, 'UFSeApd8wCQu673d096b53fed7e80b0af1c4e2189d62.png',
        'E:\\avatar\\2023-10-04/1696432964696-58c371ea-4c94-4b80-aab0-81e3f475c714.png',
        '673d096b53fed7e80b0af1c4e2189d62', 1, '2023-10-04 23:22:45');
INSERT INTO `attachment`
VALUES (1709723511700008962, 'YrPZeFGkd4D5fb34af4529e9e575c2ea7aefb64f7326.png',
        'E:\\avatar\\2023-10-05/1696464824969-b5774a0b-9ab8-43b9-b61f-908d47c7346f.png',
        'fb34af4529e9e575c2ea7aefb64f7326', 1, '2023-10-05 08:13:45');
INSERT INTO `attachment`
VALUES (1709798321096396801, 'TbBsXhODKpCBfbd4987806c24d12fb6b73d678d08533.png',
        'E:\\avatar\\2023-10-05/1696482660922-fef1faab-6914-4328-b441-e00e3c0dd8db.png',
        'fbd4987806c24d12fb6b73d678d08533', 1, '2023-10-05 13:11:01');
INSERT INTO `attachment`
VALUES (1709811698757709826, '59MDPnpkv7Wt7fbd4d7af586bcda2e3c4b977f24b22c.png',
        'E:\\avatar\\2023-10-05/1696485850407-671c1a8d-206a-49f9-80ed-5e583338330d.png',
        '7fbd4d7af586bcda2e3c4b977f24b22c', 1, '2023-10-05 14:04:10');
INSERT INTO `attachment`
VALUES (1709811698820624385, 'D6Lz792TafWD1ae168499f9e79f29ca005fd4e9d683d.png',
        'E:\\avatar\\2023-10-05/1696485850420-2a67c8d8-f63d-4041-b6eb-1b6ad7b44772.png',
        '1ae168499f9e79f29ca005fd4e9d683d', 1, '2023-10-05 14:04:10');
INSERT INTO `attachment`
VALUES (1709811698820624386, 'BEndwr3ky6Z78fa69c8e0aa069bcb5a9e45ec9ac758c.png',
        'E:\\avatar\\2023-10-05/1696485850431-112cb363-9c7b-4dd6-9cd9-71294925f1d6.png',
        '8fa69c8e0aa069bcb5a9e45ec9ac758c', 1, '2023-10-05 14:04:10');
INSERT INTO `attachment`
VALUES (1709814733785444353, 'BWPMb7x72uvgeaf57fd23897d1f0f3b9c3e7f139444c.gif',
        'E:\\avatar\\2023-10-05/1696486574011-355dc242-86b7-4cf3-a29b-0a72d445f28d.gif',
        'eaf57fd23897d1f0f3b9c3e7f139444c', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814733852553217, 'lpyQy2q2HTPc28698ff68d29b24c4c26f8bd14b5de22.png',
        'E:\\avatar\\2023-10-05/1696486574020-f03def4e-6da0-4566-a8f1-11cd31b632ca.png',
        '28698ff68d29b24c4c26f8bd14b5de22', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814733852553218, 'P2R3SaLAneQWa71c56dc822a7a9cf868d955f2112e07.png',
        'E:\\avatar\\2023-10-05/1696486574033-c004c28a-6cb1-4fc8-9672-abedc8216865.png',
        'a71c56dc822a7a9cf868d955f2112e07', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814733915467778, 'YV2Zn5RwJ4yweef862639bf195fe009e91f7141b655c.jpg',
        'E:\\avatar\\2023-10-05/1696486574041-0e9133fb-7809-43cb-b7e4-3111410306cc.jpg',
        'eef862639bf195fe009e91f7141b655c', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814733915467779, 'l64mRa8zY2199854915f487ff085915e2b4f8c8e1153.jpg',
        'E:\\avatar\\2023-10-05/1696486574050-e115763d-4363-41c5-8714-d6274674fab7.jpg',
        '9854915f487ff085915e2b4f8c8e1153', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814733978382337, 'Rh4oecBfy6YD6d4edfc0ebb1f00706c824a81e7e9e54.jpg',
        'E:\\avatar\\2023-10-05/1696486574060-6fe484c4-dc71-4828-844b-6604e0e61a22.jpg',
        '6d4edfc0ebb1f00706c824a81e7e9e54', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814733978382338, 'vW0kAGKr6ljq32e3b63cc802ca85892e55101b923327.jpg',
        'E:\\avatar\\2023-10-05/1696486574069-0a3870de-01bf-441a-8d17-4e1f9372ecd9.jpg',
        '32e3b63cc802ca85892e55101b923327', 1, '2023-10-05 14:16:14');
INSERT INTO `attachment`
VALUES (1709814856313647105, 'Hwn8wvPJxNP7adedc74c0de534c788acb4eedefb6804.jpg',
        'E:\\avatar\\2023-10-05/1696486603234-04cf381a-3dc1-441d-9a97-48393b9759ef.jpg',
        'adedc74c0de534c788acb4eedefb6804', 1, '2023-10-05 14:16:43');
INSERT INTO `attachment`
VALUES (1709814895316480002, '74IEwS9OfyC2d8724ac565f66d39ce708b57c2ddde09.png',
        'E:\\avatar\\2023-10-05/1696486612521-33bc55a2-e498-48f7-bb7e-23aa2773e224.png',
        'd8724ac565f66d39ce708b57c2ddde09', 1, '2023-10-05 14:16:53');
INSERT INTO `attachment`
VALUES (1709814958688219138, 'aSGYI5tWYUqhe2478b0eda1c1c98966a9602cea1b7ca.png',
        'E:\\avatar\\2023-10-05/1696486627637-61badb91-f166-4741-b4cd-572e55eaff22.png',
        'e2478b0eda1c1c98966a9602cea1b7ca', 1, '2023-10-05 14:17:08');
INSERT INTO `attachment`
VALUES (1709821383699247105, 'tmp_07fdd8b6fddd6bc913b2391754bbae7fedb460adbc47b8d0.jpg',
        'E:\\avatar\\2023-10-05/1696488159472-1d28ed03-f4b0-4195-8a8e-7e054a3b0b7b.jpg',
        '4dbb9192cd6fbf499d93d3d53a93b43d', 1, '2023-10-05 14:42:39');
INSERT INTO `attachment`
VALUES (1709821609960976385, 'tmp_81c74329556891395eb17c70f5410a43bad84e0c8a0bd849.jpg',
        'E:\\avatar\\2023-10-05/1696488213420-1c1f547c-93a9-4a7b-9959-6f103b46d448.jpg',
        'c779d5038d19eb9f9b680ab11a6efd18', 1, '2023-10-05 14:43:33');
INSERT INTO `attachment`
VALUES (1709902396458663938, 't7rMITpC3K76be20df6a4dca2ce18efdefeaed203c66.jpg',
        'E:\\avatar\\2023-10-05/1696507474276-a19a3669-2975-406b-9421-38d869097c36.jpg',
        'be20df6a4dca2ce18efdefeaed203c66', 1, '2023-10-05 20:04:34');
INSERT INTO `attachment`
VALUES (1709903969586905090, '2CSGi6So0Ya796b261098394455ee404b3134e626c05.jpg',
        'E:\\avatar\\2023-10-05/1696507849494-602be2af-5bc2-4d7e-8bf8-226069dd1629.jpg',
        '96b261098394455ee404b3134e626c05', 1, '2023-10-05 20:10:49');
INSERT INTO `attachment`
VALUES (1709903969654013954, 'kCi0s8pAHEkY07253582140d32c9381f048eec16c1f3.png',
        'E:\\avatar\\2023-10-05/1696507849512-d5e8f073-9587-41c1-9520-96289977004a.png',
        '07253582140d32c9381f048eec16c1f3', 1, '2023-10-05 20:10:50');
INSERT INTO `attachment`
VALUES (1710115057503129601, 'wn8frq54yujz53ba03ac1219f4297bc4bf6f06f078c4.png',
        'E:\\avatar\\2023-10-06/1696558176759-688cee58-21a5-4391-9bac-31694f0b6534.png',
        '53ba03ac1219f4297bc4bf6f06f078c4', 1, '2023-10-06 10:09:37');
INSERT INTO `attachment`
VALUES (1710115057511518209, 'GpnwZufp3rbI534ced3c3c6f7847324b46b937122cd3.jpg',
        'E:\\avatar\\2023-10-06/1696558176767-642fb142-96e5-486a-ba40-1fffbc13a32f.jpg',
        '534ced3c3c6f7847324b46b937122cd3', 1, '2023-10-06 10:09:37');
INSERT INTO `attachment`
VALUES (1710115057532489729, 'v2rE97PaI5xN13b2da2d83d4435d742e8b24e2edb886.jpg',
        'E:\\avatar\\2023-10-06/1696558176782-d71593bd-9ae1-4e2f-8f05-606ff126b0f6.jpg',
        '13b2da2d83d4435d742e8b24e2edb886', 1, '2023-10-06 10:09:37');
INSERT INTO `attachment`
VALUES (1710198175920627713, '7LuD7sFYmsxFfbfec293f79954c3adfb7efda0b7082d.png',
        'E:\\avatar\\2023-10-06/1696577993744-a66e95d2-28cd-4cf8-858d-d3c1105c4a58.png',
        'fbfec293f79954c3adfb7efda0b7082d', 1, '2023-10-06 15:39:54');
INSERT INTO `attachment`
VALUES (1710205797268791297, 'DEVRagHjHnDm5cccd78e97f56b3a82999c6355920ad7.jpg',
        'E:\\avatar\\2023-10-06/1696579810812-dfb6fe5e-ec87-4a93-a051-c36eb03afbb7.jpg',
        '5cccd78e97f56b3a82999c6355920ad7', 1, '2023-10-06 16:10:11');
INSERT INTO `attachment`
VALUES (1710222764457402370, 'eCDiOz2aekQDa9dc9f69428895bdde6eb23d273c30e6.png',
        'E:\\avatar\\2023-10-06/1696583856103-78f09fa9-1689-4211-b7fe-0bb2f764edae.png',
        'a9dc9f69428895bdde6eb23d273c30e6', 1, '2023-10-06 17:17:36');
INSERT INTO `attachment`
VALUES (1710223764329144322, 'pUUUmDOEmLuu4dc210ffd2d8c6c0c9b00b1ce63560e7.jpg',
        'E:\\avatar\\2023-10-06/1696584094497-256759e1-db2c-42c7-81f5-7e9916622e68.jpg',
        '4dc210ffd2d8c6c0c9b00b1ce63560e7', 1, '2023-10-06 17:21:35');
INSERT INTO `attachment`
VALUES (1710223833816178690, 'w2T2oC03ovyUd2f0486b633ac191e5c6f7ca7fb60041.png',
        'E:\\avatar\\2023-10-06/1696584111072-7a2d23f7-6ae2-4caf-a429-2abaabde46bc.png',
        'd2f0486b633ac191e5c6f7ca7fb60041', 1, '2023-10-06 17:21:51');
INSERT INTO `attachment`
VALUES (1710224317188743170, 'ZnFQzhMnvNUz050738d64f7746521a42d1dc36cb8ddf.jpg',
        'E:\\avatar\\2023-10-06/1696584226305-bc3cdacd-02bf-4759-88f8-9c232890e202.jpg',
        '050738d64f7746521a42d1dc36cb8ddf', 1, '2023-10-06 17:23:46');
INSERT INTO `attachment`
VALUES (1710225436547817474, 'TGRBZPuNszeO963c2f9cb890172104a14c4691b194eb.jpg',
        'E:\\avatar\\2023-10-06/1696584493123-f87dd94e-b00a-4488-92b0-213e44fb6e15.jpg',
        '963c2f9cb890172104a14c4691b194eb', 1, '2023-10-06 17:28:13');
INSERT INTO `attachment`
VALUES (1710227597650370561, 'SQ14xBobrqKi1f483d159734d55bcaa65e8a8c57b30c.jpg',
        'E:\\avatar\\2023-10-06/1696585008420-a53e2f37-b944-44d1-aa97-9a701fbcc3c9.jpg',
        '1f483d159734d55bcaa65e8a8c57b30c', 1, '2023-10-06 17:36:48');
INSERT INTO `attachment`
VALUES (1710230218230538242, 'zW4t9YdBJmRI8994fc335227501268c78e86f22a4438.jpg',
        'E:\\avatar\\2023-10-06/1696585633227-1fcd463a-6e48-45c9-8ec9-5e0b7ce860e1.jpg',
        '8994fc335227501268c78e86f22a4438', 1, '2023-10-06 17:47:13');
INSERT INTO `attachment`
VALUES (1710230258370027521, 'u5I7iB0RJu2q57557dc2ceec888b32dc50c2cb631774.jpg',
        'E:\\avatar\\2023-10-06/1696585642790-a4e70304-bf0c-4461-a4e9-637a97ef9e60.jpg',
        '57557dc2ceec888b32dc50c2cb631774', 1, '2023-10-06 17:47:23');
INSERT INTO `attachment`
VALUES (1710264921327235074, 'lIMsuJXwgBOvb9b316a77894b8b0205d8f7b1e25fe44.jpg',
        'E:\\avatar\\2023-10-06/1696593907081-3a1cfecd-8fb4-4139-9661-4712ba3d50ef.jpg',
        'b9b316a77894b8b0205d8f7b1e25fe44', 1, '2023-10-06 20:05:07');
INSERT INTO `attachment`
VALUES (1710264935575285761, 'TxKwq6drLX6Lf1d962086bccc6d3cbd206ecee977d6e.jpg',
        'E:\\avatar\\2023-10-06/1696593910478-278497fe-026b-4264-9e8a-0c38158e79f6.jpg',
        'f1d962086bccc6d3cbd206ecee977d6e', 1, '2023-10-06 20:05:10');
INSERT INTO `attachment`
VALUES (1710266593524936705, '0wO7RgIuECip3ca27589df8facfe00514b950ba83963.jpg',
        'E:\\avatar\\2023-10-06/1696594305776-600da723-832b-4f1e-9f22-40a9276ccd78.jpg',
        '3ca27589df8facfe00514b950ba83963', 1, '2023-10-06 20:11:46');
INSERT INTO `attachment`
VALUES (1710266609232605186, 'rF2Ijo4BZReTa4741aae3cced31feca025c43a61c043.jpg',
        'E:\\avatar\\2023-10-06/1696594309510-1d31ad6c-0cca-4fcd-8c9c-d6f74bdedbcb.jpg',
        'a4741aae3cced31feca025c43a61c043', 1, '2023-10-06 20:11:50');
INSERT INTO `attachment`
VALUES (1710298540779335682, 'tmp_a9a10885b19b695e3413bc5d7302838f54887bb4358e4c41.jpg',
        'E:\\avatar\\2023-10-06/1696601922587-c69eb0d2-4d1f-4938-927d-3fd2150f5700.jpg',
        'd3a022bcc2966c681a3558b7b808008d', 1, '2023-10-06 22:18:43');
INSERT INTO `attachment`
VALUES (1710438123433193473, 'kjKtcokpq64r5d7475541b2cd9dacc7e4724a2429a4a.jpg',
        'E:\\avatar\\2023-10-07/1696635201684-bbf8471a-3039-4652-9ba2-fff0d64f1587.jpg',
        '5d7475541b2cd9dacc7e4724a2429a4a', 1, '2023-10-07 07:33:22');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id`     bigint(20) NOT NULL COMMENT '帖子id',
    `create_by`   bigint(20) NOT NULL COMMENT '用户id',
    `create_time` datetime   NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `collect_post_id_create_by_uindex` (`post_id`, `create_by`) USING BTREE COMMENT '高并发下的数据重复插入问题'
) ENGINE = MyISAM
  AUTO_INCREMENT = 1710533480745889795
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect`
VALUES (1709801094517002241, 1709545967126261761, 1, '2023-10-05 13:22:02');
INSERT INTO `collect`
VALUES (1709805831131934721, 1709723550363103234, 1, '2023-10-05 13:40:51');
INSERT INTO `collect`
VALUES (1709801959801917442, 1709545968107728898, 1, '2023-10-05 13:25:28');
INSERT INTO `collect`
VALUES (1709801098119909377, 1709545956598558722, 1, '2023-10-05 13:22:03');
INSERT INTO `collect`
VALUES (1709815971440668674, 1709815010643062786, 1, '2023-10-05 14:21:09');
INSERT INTO `collect`
VALUES (1709810615222185986, 1709542520909934594, 1, '2023-10-05 13:59:52');
INSERT INTO `collect`
VALUES (1710273135762567169, 1709815566698721282, 1, '2023-10-06 20:37:46');
INSERT INTO `collect`
VALUES (1710265191432024066, 1710115498680995841, 1, '2023-10-06 20:06:11');
INSERT INTO `collect`
VALUES (1710462062523936770, 1709821653518823425, 1, '2023-10-07 09:08:29');
INSERT INTO `collect`
VALUES (1710128506324996097, 1709814622154043394, 1, '2023-10-06 11:03:03');
INSERT INTO `collect`
VALUES (1710268129319677954, 1709821436950130690, 1, '2023-10-06 20:17:52');
INSERT INTO `collect`
VALUES (1710271845426884610, 1709879318034956289, 1, '2023-10-06 20:32:38');
INSERT INTO `collect`
VALUES (1710273056217591809, 1710115129406083073, 1, '2023-10-06 20:37:27');
INSERT INTO `collect`
VALUES (1710533480745889794, 1710298585452867585, 1, '2023-10-07 13:52:17');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`
(
    `id`             bigint(20)                                                     NOT NULL AUTO_INCREMENT,
    `post_id`        bigint(20)                                                     NOT NULL COMMENT '帖子id',
    `create_by`      bigint(20)                                                     NOT NULL,
    `comment_detail` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `comment_ids`    varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论的评论',
    `create_time`    datetime                                                       NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for like_records
-- ----------------------------
DROP TABLE IF EXISTS `like_records`;
CREATE TABLE `like_records`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id`     bigint(20) NOT NULL COMMENT '帖子id',
    `create_by`   bigint(20) NOT NULL COMMENT '用户id',
    `create_time` datetime   NOT NULL COMMENT '时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `like_records_create_by_post_id_uindex` (`create_by`, `post_id`) USING BTREE COMMENT '高并发下的数据重复插入问题'
) ENGINE = MyISAM
  AUTO_INCREMENT = 1710533469043781635
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of like_records
-- ----------------------------
INSERT INTO `like_records`
VALUES (1710128505335140353, 1709814622154043394, 1, '2023-10-06 11:03:03');
INSERT INTO `like_records`
VALUES (1709577456295555074, 1709573479222947841, 1, '2023-10-04 22:33:23');
INSERT INTO `like_records`
VALUES (1710266360996917250, 1709821653518823425, 1, '2023-10-06 20:10:50');
INSERT INTO `like_records`
VALUES (1710265177326579714, 1710115498680995841, 1, '2023-10-06 20:06:08');
INSERT INTO `like_records`
VALUES (1709586429010718722, 1709552066835460098, 1, '2023-10-04 23:09:02');
INSERT INTO `like_records`
VALUES (1710298983773335553, 1709576354426728450, 1, '2023-10-06 22:20:28');
INSERT INTO `like_records`
VALUES (1710533469043781634, 1710298585452867585, 1, '2023-10-07 13:52:14');

-- ----------------------------
-- Table structure for post_details
-- ----------------------------
DROP TABLE IF EXISTS `post_details`;
CREATE TABLE `post_details`
(
    `id`          bigint(20)                                                     NOT NULL AUTO_INCREMENT,
    `title`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NOT NULL COMMENT '标题',
    `intro`       varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '介绍',
    `imgs`        varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL     DEFAULT NULL COMMENT '图片id集合',
    `create_time` datetime                                                       NOT NULL COMMENT '发布时间',
    `update_time` datetime                                                       NOT NULL,
    `create_by`   bigint(20)                                                     NOT NULL COMMENT '发布人',
    `rented`      tinyint(4)                                                     NOT NULL DEFAULT 0 COMMENT '是否已经出租',
    `is_deleted`  tinyint(4)                                                     NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1710298585452867586
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '帖子详细信息'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_details
-- ----------------------------
INSERT INTO `post_details`
VALUES (1709542508536737793, '123', '123',
        '[1709401009743806465,1709098413397155842,1709400483459317761,1709073281232445442,1709066279122935809]',
        '2023-10-04 20:14:30', '2023-10-05 14:00:03', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709542509635645441, '123', '123',
        '[1709401009743806465,1709098413397155842,1709400483459317761,1709073281232445442,1709066279122935809]',
        '2023-10-04 20:14:31', '2023-10-05 14:00:42', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709542520909934594, '123', '123',
        '[1709401009743806465,1709098413397155842,1709400483459317761,1709073281232445442,1709066279122935809]',
        '2023-10-04 20:14:33', '2023-10-05 14:00:40', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709811710812139521, '123123', '123123',
        '[1709589879941443586,1709589879878529026,1709589880008552450,1709811698757709826,1709811698820624385,1709811698820624386]',
        '2023-10-05 14:04:13', '2023-10-05 14:05:03', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709546023086665730, '123123', '123123123', '[1709072951899889666]', '2023-10-04 20:28:28',
        '2023-10-05 13:59:34', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709549543395373058, '11', '11', '[1709549532318216194]', '2023-10-04 20:42:28', '2023-10-05 13:59:05', 1, 0,
        1);
INSERT INTO `post_details`
VALUES (1709551915819544578, '123', '123', '[1709549532318216194]', '2023-10-04 20:51:53', '2023-10-05 13:59:04', 1, 0,
        1);
INSERT INTO `post_details`
VALUES (1709552011277709314, '1', '1', '[1709552005883834370]', '2023-10-04 20:52:16', '2023-10-05 13:56:58', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709552066835460098, '1', '1', '[1709552058610429954,1709552058610429955,1709552059990355969]',
        '2023-10-04 20:52:29', '2023-10-05 13:58:59', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709552783700733954, '123123123', '123123',
        '[1709402725335777282,1709402725398691841,1709404178066522113,1709049607804723201,1709049653568774146,1709401009743806465,1709098413397155842,1709400483459317761,1709098413397155842]',
        '2023-10-04 20:55:20', '2023-10-05 13:56:48', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709569143717703682, '哈哈哈测试一下', '测试测试测试测试',
        '[1709569078877958145,1709402702065778689,1709402702065778690,1709402702132887553,1709402702195802113,1709402702262910977,1709402702455848961]',
        '2023-10-04 22:00:21', '2023-10-05 13:54:41', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709573479222947841, '123', '123', '[1709404178066522113]', '2023-10-04 22:17:34', '2023-10-05 13:51:57', 1, 0,
        1);
INSERT INTO `post_details`
VALUES (1709576354426728450, '记录一天的美好', '哈哈哈哈哈嚯嚯嚯',
        '[1709447454258311169,1709447454258311170,1709576300349566977,1709576300349566978,1709576300349566979,1709576300416675842,1709576300550893570,1709576300550893571,1709576300550893572]',
        '2023-10-04 22:29:00', '2023-10-04 22:29:00', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709589918268993538, '测试一下测试测试', '哈哈哈哈',
        '[1709552058610429955,1709552059990355969,1709589866167349250,1709589866234458114,1709589866297372673,1709589879811420161,1709589879878529026,1709589879941443586,1709589880008552450]',
        '2023-10-04 23:22:54', '2023-10-05 13:54:34', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709723202663690241, '测试一下最长标题测试一下最长标题测试一下',
        '测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下',
        '[1709098413397155842,1709400483459317761,1709073281232445442,1709066279122935809,1709049677480501250]',
        '2023-10-05 08:12:31', '2023-10-05 13:54:31', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709723550363103234, '你好世界', '哈哈哈',
        '[1709400483459317761,1709073281232445442,1709066279122935809,1709049677480501250,1709723511700008962,1709409610319347713,1709409610449371137]',
        '2023-10-05 08:13:54', '2023-10-05 13:54:27', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709798279983828994, '123123123', '123123123123',
        '[1709073281232445442,1709066279122935809,1709049677480501250]', '2023-10-05 13:10:51', '2023-10-05 13:54:24',
        1, 0, 1);
INSERT INTO `post_details`
VALUES (1709798332865613826, '123123123', '3123123213',
        '[1709798321096396801,1709569078877958145,1709402702065778689,1709402702065778690,1709402702132887553,1709402702195802113,1709402702262910977]',
        '2023-10-05 13:11:04', '2023-10-05 13:54:15', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709814622154043394, '123', '123',
        '[1709723511700008962,1709409610319347713,1709409610449371137,1709409610449371138,1709072951899889666]',
        '2023-10-05 14:15:47', '2023-10-05 14:15:47', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814650864054273, '123', '123',
        '[1709723511700008962,1709409610319347713,1709409610449371137,1709409610449371138,1709072951899889666,1709060810086064130]',
        '2023-10-05 14:15:54', '2023-10-05 14:15:54', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814689170632706, '123', '23',
        '[1709569078877958145,1709402702065778689,1709402702065778690,1709402702132887553,1709402702195802113,1709402702262910977,1709402702455848961]',
        '2023-10-05 14:16:03', '2023-10-05 14:16:03', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814747429515265, '123123', '123',
        '[1709814733785444353,1709814733852553217,1709814733852553218,1709814733915467778,1709814733915467779,1709814733978382337,1709814733978382338]',
        '2023-10-05 14:16:17', '2023-10-05 14:16:17', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814810637676545, '123123123', '123123123213',
        '[1709401009743806465,1709098413397155842,1709400483459317761,1709073281232445442,1709066279122935809,1709049677480501250,1709569078877958145,1709402702065778689,1709402702065778690]',
        '2023-10-05 14:16:32', '2023-10-05 14:16:32', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814864408653826, '1', '11', '[1709814856313647105]', '2023-10-05 14:16:45', '2023-10-05 14:16:45', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814902669094913, '111', '111',
        '[1709814895316480002,1709723511700008962,1709409610319347713,1709409610449371137]', '2023-10-05 14:16:54',
        '2023-10-05 14:16:54', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709814960827314177, '111', '1111', '[1709814958688219138]', '2023-10-05 14:17:08', '2023-10-05 14:17:08', 1, 0,
        0);
INSERT INTO `post_details`
VALUES (1709815010643062786, '111', '1111',
        '[1709402851664019457,1709402604812451842,1709401561449971713,1709401561449971714,1709060796295192577,1709402605013778434]',
        '2023-10-05 14:17:20', '2023-10-05 14:43:16', 1, 0, 1);
INSERT INTO `post_details`
VALUES (1709815566698721282, '1', '2',
        '[1709814733852553217,1709814733852553218,1709814733915467778,1709814733915467779,1709814733978382337,1709814733978382338]',
        '2023-10-05 14:19:33', '2023-10-05 14:19:33', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709821436950130690, '蓝发小猫咪', '喜欢😋', '[1709821383699247105]', '2023-10-05 14:42:52',
        '2023-10-05 14:42:52', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709821653518823425, '卷卷卷', '太卷了太卷了太卷了', '[1709821609960976385]', '2023-10-05 14:43:44',
        '2023-10-05 14:43:44', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709878943978536961, '傻逼', '11', '[1709400483459317761]', '2023-10-05 18:31:23', '2023-10-05 18:31:23', 1, 0,
        0);
INSERT INTO `post_details`
VALUES (1709879318034956289, '严禁虚假宣传祈福、涉嫌迷信用语', '111', '[1709073281232445442]', '2023-10-05 18:32:52',
        '2023-10-05 18:32:52', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709879690371710977, '111', '五星红旗迎风飘扬', '[1709400483459317761]', '2023-10-05 18:34:21',
        '2023-10-05 18:34:21', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709881765398757377, '1111', '毛泽东', '[1709098413397155842]', '2023-10-05 18:42:36', '2023-10-05 20:05:12', 1,
        0, 1);
INSERT INTO `post_details`
VALUES (1709891157435219969, '毛', '毛泽东', '[1709060796295192577]', '2023-10-05 19:19:55', '2023-10-05 20:04:59', 1,
        0, 1);
INSERT INTO `post_details`
VALUES (1709901327317991426, '毛1泽11东', '***', '[1709049607804723201]', '2023-10-05 20:00:20', '2023-10-05 20:04:56',
        1, 0, 1);
INSERT INTO `post_details`
VALUES (1709902428394094593, '测试测试测试', '****迎风飘扬，***的画像屹立在***前。', '[1709902396458663938]',
        '2023-10-05 20:04:42', '2023-10-05 20:04:42', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1709904213871558658, '我是QCQCQC', '测试一下',
        '[1709814733852553218,1709814733915467778,1709814733915467779,1709814733978382337,1709814733978382338,1709903969586905090,1709903969654013954,1709589879941443586,1709589880008552450]',
        '2023-10-05 20:11:48', '2023-10-05 20:11:48', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1710115129406083073, '测试一下最长标题测试一下最长标题测试一下',
        '测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下最长标题测试一下',
        '[1709814733785444353,1709444058000351234,1710115057503129601,1710115057511518209,1710115057532489729,1709569078877958145,1709402702065778689,1709402702065778690,1709402702132887553]',
        '2023-10-06 10:09:54', '2023-10-06 10:09:54', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1710115498680995841, 'nav_itemnav_itemnav_',
        'nav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_item\nnav_i',
        '[1709402702065778689,1709402702065778690,1709402702132887553,1709402702195802113,1709402702262910977]',
        '2023-10-06 10:11:22', '2023-10-06 10:11:22', 1, 0, 0);
INSERT INTO `post_details`
VALUES (1710176946090221570, '啥 比', '123', '[1709098413397155842]', '2023-10-06 14:15:32', '2023-10-06 14:21:17', 1,
        0, 1);
INSERT INTO `post_details`
VALUES (1710298585452867585, '今天饭菜好贵', '贵贵贵', '[1710298540779335682]', '2023-10-06 22:18:53',
        '2023-10-06 22:18:53', 1, 0, 0);

-- ----------------------------
-- Table structure for share_records
-- ----------------------------
DROP TABLE IF EXISTS `share_records`;
CREATE TABLE `share_records`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id`     bigint(20) NOT NULL COMMENT '被分享的帖子id',
    `create_by`   bigint(20) NOT NULL COMMENT '分享人',
    `create_time` datetime   NOT NULL COMMENT '分享日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of share_records
-- ----------------------------

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `publisher_id` bigint(20) NOT NULL COMMENT '发帖用户id',
    `create_by`    bigint(20) NOT NULL COMMENT '关注人',
    `create_time`  datetime   NOT NULL COMMENT '关注时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `subscribe_create_by_publisher_id_uindex` (`create_by`, `publisher_id`) USING BTREE COMMENT '高并发下的数据重复插入问题'
) ENGINE = MyISAM
  AUTO_INCREMENT = 1710671285237174274
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of subscribe
-- ----------------------------
INSERT INTO `subscribe`
VALUES (1710280213155639298, 1, 0, '2023-10-06 21:05:53');
INSERT INTO `subscribe`
VALUES (1710671285237174273, 1, 1, '2023-10-07 22:59:52');
INSERT INTO `subscribe`
VALUES (123123123123123, 1, 2, '2023-10-07 14:15:34');
INSERT INTO `subscribe`
VALUES (1710540497254445059, 1, 3, '2023-10-07 14:25:25');
INSERT INTO `subscribe`
VALUES (1710540497254445060, 1, 4, '2023-10-07 14:25:33');
INSERT INTO `subscribe`
VALUES (1710540497254445061, 1, 5, '2023-10-07 14:25:39');
INSERT INTO `subscribe`
VALUES (1710540497254445062, 1, 6, '2023-10-07 14:25:43');
INSERT INTO `subscribe`
VALUES (1710540497254445063, 1, 7, '2023-10-07 14:25:48');
INSERT INTO `subscribe`
VALUES (1710540497254445064, 1, 8, '2023-10-07 14:25:53');
INSERT INTO `subscribe`
VALUES (1710540497254445065, 1, 9, '2023-10-07 14:25:58');
INSERT INTO `subscribe`
VALUES (1710540497254445066, 1, 10, '2023-10-07 14:26:05');
INSERT INTO `subscribe`
VALUES (1710540497254445067, 1, 11, '2023-10-07 14:26:11');
INSERT INTO `subscribe`
VALUES (1710540497254445068, 1, 12, '2023-10-07 14:26:16');
INSERT INTO `subscribe`
VALUES (1710540497254445069, 1, 13, '2023-10-07 14:26:22');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `id`          bigint(20)                                                     NOT NULL AUTO_INCREMENT COMMENT 'id',
    `link_man`    varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL     DEFAULT NULL COMMENT '联系方式',
    `username`    varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '登录账号',
    `avatar`      varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL,
    `background`  varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL,
    `password`    varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `mobile`      varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NULL     DEFAULT NULL COMMENT '手机号',
    `nick_name`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NOT NULL DEFAULT '默认用户名' COMMENT '用户名',
    `school`      varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '某知名高校' COMMENT '学校',
    `roles`       varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '[\"ROLE_USER\"]',
    `create_time` datetime                                                       NOT NULL,
    `disabled`    tinyint(4)                                                     NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 16
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info`
VALUES (1, NULL, 'admin', 'http://192.168.3.10:8081/common/img/1709066279122935809',
        'http://192.168.3.10:8081/common/img/1710266609232605186',
        '$2a$10$CoZgwepHxy7qwgPxv2p5z.0jkiiPsdaGS7crKuQlZj3jpUGNkaPM.', '15382500000', 'QCQCQC', '浙江科技学院',
        '[\"ROLE_ADMIN\"]', '2023-10-05 09:50:04', 0);
INSERT INTO `user_info`
VALUES (2, NULL, 'user', 'http://192.168.3.10:8081/common/img/1709814733785444353',
        'http://192.168.3.10:8081/common/img/1709402702065778689',
        '$2a$10$CoZgwepHxy7qwgPxv2p5z.0jkiiPsdaGS7crKuQlZj3jpUGNkaPM.', NULL, '默认用户名', '某知名高校',
        '[\"ROLE_USER\"]', '2023-10-07 14:14:58', 0);
INSERT INTO `user_info`
VALUES (3, NULL, '333', NULL, NULL, '333', NULL, '默认用户名', '某知名高校', '[\"ROLE_USER\"]', '2023-10-07 14:24:06',
        0);
INSERT INTO `user_info`
VALUES (4, NULL, '4444', NULL, NULL, '4444', NULL, '默认用户名', '某知名高校', '[\"ROLE_USER\"]', '2023-10-07 14:24:20',
        0);
INSERT INTO `user_info`
VALUES (5, NULL, '5555', NULL, NULL, '5555', NULL, '默认用户名', '某知名高校', '[\"ROLE_USER\"]', '2023-10-07 14:24:42',
        0);
INSERT INTO `user_info`
VALUES (6, 'kQ0hEQlcYK', 'Edward Thomas', '6CVJqk8kzm', 'HhVirzNwQ8', 'ZA6A65R3cs', 'KM0BztfnrJ', 'Edward Thomas',
        'G5PiCafYae', '[\"ROLE_USER\"]', '2013-03-27 14:08:18', 0);
INSERT INTO `user_info`
VALUES (7, '4qWnCmQ9k1', 'Song Rui', 'iFSUxwJF0F', 'iBVNbKGawO', 'SpfejqCgV4', 'FDt4hSPO3O', 'Song Rui', 'khCUtaigeh',
        '[\"ROLE_USER\"]', '2002-11-09 03:02:45', 0);
INSERT INTO `user_info`
VALUES (8, '7v3n7gIzln', 'Ho Sai Wing', 'rOoKK0K86j', '3k3yFFUJyG', 's7gJhKlqHg', '7Jfwu5rC5F', 'Ho Sai Wing',
        '4XbXMT4eVi', '[\"ROLE_USER\"]', '2014-03-20 13:57:51', 0);
INSERT INTO `user_info`
VALUES (9, '1N4DDlTJ1b', 'Suzuki Momoe', 'iyQ4i0mGJ5', '46YwLAHP21', 'zcmHRvefhB', 'x0jtWuIpfj', 'Suzuki Momoe',
        'PH6A0sbnbu', '[\"ROLE_USER\"]', '2021-05-21 13:02:30', 0);
INSERT INTO `user_info`
VALUES (10, 'K7CPbKNXFL', 'Kondo Misaki', 'PbDvlN4ChY', 'LH38casA9P', 'z3VgXothNc', 'F1OHsHK91M', 'Kondo Misaki',
        'Pno6f6o5pj', '[\"ROLE_USER\"]', '2006-08-11 06:18:04', 0);
INSERT INTO `user_info`
VALUES (11, 'RL8tPIh5BD', 'Valerie Flores', 'dUxt2vfeqd', 'rtJWg6hZlI', '6OzsYqiNwA', 'l8x2XbWE8A', 'Valerie Flores',
        'bmIhycNBub', '[\"ROLE_USER\"]', '2012-05-28 23:50:38', 0);
INSERT INTO `user_info`
VALUES (12, '4ouQSGsueY', 'Kobayashi Hazuki', 'QDSfVkvE8p', 'sdKg9CQhfk', 'ne5pzTrvQd', 'TTcLfgCmXM',
        'Kobayashi Hazuki', 'tj1NmT8tyz', '[\"ROLE_USER\"]', '2012-09-28 16:23:17', 0);
INSERT INTO `user_info`
VALUES (13, 'dYtPyraUDv', 'Harada Aoi', 'k9il5jtR79', 'Tnn9hweIvk', 'd39o5CcE67', 'x0nPCuXO4t', 'Harada Aoi',
        'luLXwoEvZl', '[\"ROLE_USER\"]', '2022-06-20 18:37:19', 0);
INSERT INTO `user_info`
VALUES (14, 'hKRgmdGqoD', 'David Schmidt', 'TPi42UMTXu', 'M9U0GPhW5O', '81PEymfgWP', 'CkD0IIAPX3', 'David Schmidt',
        'w17TTgPN7O', '[\"ROLE_USER\"]', '2006-09-17 18:29:21', 0);
INSERT INTO `user_info`
VALUES (15, 'lNH6jrBdmp', 'Miu Chi Yuen', '8W3PwbZ5xm', 'MXQOkk9nOi', 'h2yfELMsiX', '0ks3Vt9hCV', 'Miu Chi Yuen',
        'lNyoOY6Tzx', '[\"ROLE_USER\"]', '2012-01-22 16:44:26', 0);

-- ----------------------------
-- Table structure for view_records
-- ----------------------------
DROP TABLE IF EXISTS `view_records`;
CREATE TABLE `view_records`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id`     bigint(20) NOT NULL COMMENT '被看的帖子',
    `create_by`   bigint(20) NOT NULL COMMENT '谁看的',
    `create_time` datetime   NOT NULL COMMENT '什么时候看的',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `view_records_create_by_post_id_uindex` (`create_by`, `post_id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 1710438054709522434
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of view_records
-- ----------------------------
INSERT INTO `view_records`
VALUES (1710285777029918721, 1710115498680995841, 1, '2023-10-06 21:27:59');
INSERT INTO `view_records`
VALUES (1710295645874909185, 1710115129406083073, 1, '2023-10-06 22:07:12');
INSERT INTO `view_records`
VALUES (1710297945909587970, 1709879318034956289, 1, '2023-10-06 22:16:21');
INSERT INTO `view_records`
VALUES (1710297964649738241, 1709878943978536961, 1, '2023-10-06 22:16:25');
INSERT INTO `view_records`
VALUES (1710298030902964226, 1709904213871558658, 1, '2023-10-06 22:16:41');
INSERT INTO `view_records`
VALUES (1710298429802246145, 1709902428394094593, 1, '2023-10-06 22:18:16');
INSERT INTO `view_records`
VALUES (1710298594923606018, 1710298585452867585, 1, '2023-10-06 22:18:56');
INSERT INTO `view_records`
VALUES (1710298973186912257, 1709576354426728450, 1, '2023-10-06 22:20:26');
INSERT INTO `view_records`
VALUES (1710299173137772545, 1709815566698721282, 1, '2023-10-06 22:21:13');
INSERT INTO `view_records`
VALUES (1710301553774391297, 1709814622154043394, 1, '2023-10-06 22:30:41');
INSERT INTO `view_records`
VALUES (1710438054709522433, 1709821653518823425, 1, '2023-10-07 07:33:05');

SET FOREIGN_KEY_CHECKS = 1;
