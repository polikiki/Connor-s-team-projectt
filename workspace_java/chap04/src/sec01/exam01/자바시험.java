package sec01.exam01;

import java.util.Scanner;

public class 자바시험 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String orderList[] = new String[5];
		int count = 0;
		int totalSum = 0;
		int menusum = 0;
		int menusum1 = 0;
		int menusum2 = 0;
		int menusum3 = 0;

		while (true) {
			System.out.print("1.주문하기2.주문취소3.결제하기4.끝내기" + "\n\n메뉴를 선택해 주세요");
			int menu = scan.nextInt();

			if (menu == 1) {
				System.out.println("어떤 종류의 메뉴를 선택하시겠습니다까?" + "\n 1. 커피 2. 음료 3. 돌아가기 4. 종료하기");
				String menuCh = "";
				int orderPr = 0;
				int orderOp = 0;
				int orderOp1 = 0;
				int orderOp2 = 0;
				int kind = scan.nextInt();

				if (kind == 1) {
					System.out.print("\n1.아메리카노 3000원\n2.카페 라떼 3500원\n3.카페모카 4000원" + "\n\n주문할 메뉴를 선택해 주세요:"
							+ "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
					int order = scan.nextInt();
					if (order == 100) {
						continue;
					} else if (order == 101) {
						break;
					} else {
						if (order == 1) {
							menuCh = "아메리카노";
							orderPr = 3000;
							System.out.print("샷 추가를 몇 번 하시겠습니까? 샷당 +300원" + "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
							int shotOp = scan.nextInt();
							if (shotOp == 100) {
								continue;
							} else if (shotOp == 101) {
								break;
							} else {
								orderOp = 300 * shotOp;
								System.out.println("얼음을 추가하시겠습니까? +500원" + "+\n0.아니오 1. 예"
										+ "/n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
								int iceOp = scan.nextInt();
								if (iceOp == 100) {
									continue;
								} else if (iceOp == 101) {
									break;
								} else {
									orderOp1 = 500 * iceOp;
									menusum = orderPr + orderOp + orderOp1;
									totalSum += menusum;
									orderList[count] = menuCh;
									count++;
									if (shotOp == 0 && iceOp == 0) {
										System.out.println(menuCh + "가 주문목록에 추가되었습니다.");
									} else if (shotOp == 0 && iceOp == 1) {
										System.out.println(menuCh + " 얼음추가" + "가 주문목록에 추가되었습니다.");
									} else if (shotOp > 0 && iceOp == 0) {
										System.out.println(menuCh + " 샷 " + shotOp + "추가가 주문목록에 추가되었습니다.");
									} else if (shotOp > 0 && iceOp == 1) {
										System.out.println(menuCh + " 샷 " + shotOp + " 얼음추가" + "가 주문목록에 추가되었습니다.");
									}
								}
							}

						} else if (order == 2) {
							menuCh = "카페 라떼";
							orderPr = 3500;
							System.out.print("샷 추가를 몇 번 하시겠습니까? 샷당 +300원" + "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
							int shotOp = scan.nextInt();
							if (shotOp == 100) {
								continue;
							} else if (shotOp == 101) {
								break;
							} else {
								orderOp = 300 * shotOp;

								System.out.println("얼음을 추가하시겠습니까? +500원" + "+\n0.아니오 1. 예"
										+ "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
								int iceOp = scan.nextInt();
								if (iceOp == 100) {
									continue;
								} else if (iceOp == 101) {
									break;
								} else {
									orderOp1 = 500 * iceOp;
									menusum1 = orderPr + orderOp + orderOp1;
									totalSum += menusum1;
									orderList[count] = menuCh;
									count++;
									if (shotOp == 0 && iceOp == 0) {
										System.out.println(menuCh + "가 주문목록에 추가되었습니다.");
									} else if (shotOp == 0 && iceOp == 1) {
										System.out.println(menuCh + " 얼음추가" + "가 주문목록에 추가되었습니다.");
									} else if (shotOp > 0 && iceOp == 0) {
										System.out.println(menuCh + " 샷 " + shotOp + "추가가 주문목록에 추가되었습니다.");
									} else if (shotOp > 0 && iceOp == 1) {
										System.out.println(menuCh + " 샷 " + shotOp + " 얼음추가" + "가 주문목록에 추가되었습니다.");
									}
								}
							}

						} else if (order == 3) {
							menuCh = "카페 모카";
							orderPr = 4000;
							System.out.print("샷 추가를 몇 번 하시겠습니까? 샷당 +300원" + "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
							int shotOp = scan.nextInt();
							if (shotOp == 100) {
								continue;
							} else if (shotOp == 101) {
								break;
							} else {
								orderOp = 300 * shotOp;
								System.out.println("얼음을 추가하시겠습니까? +500원" + "+\n0.아니오 1. 예"
										+ "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
								int iceOp = scan.nextInt();
								if (iceOp == 100) {
									continue;
								} else if (iceOp == 101) {
									break;
								} else {
									orderOp1 = 500 * iceOp;
									System.out.println("휘핑 크림을 추가하시겠습니까?+500원" + "+\n0.아니오 1. 예"
											+ "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
									int creamOp = scan.nextInt();
									if (creamOp == 100) {
										continue;
									} else if (creamOp == 101) {
										break;
									} else {
										orderOp2 = 500 * creamOp;
										menusum2 = orderPr + orderOp + orderOp1 + orderOp2;
										totalSum += menusum2;
										orderList[count] = menuCh;
										count++;
										if (shotOp == 0 && iceOp == 0 && creamOp == 0) {
											System.out.println(menuCh + "가 주문목록에 추가되었습니다.");
										} else if (shotOp == 0 && iceOp == 0 && creamOp == 1) {
											System.out.println(menuCh + " 휘핑크림추가" + "가 주문목록에 추가되었습니다.");
										} else if (shotOp == 0 && iceOp == 1 && creamOp == 0) {
											System.out.println(menuCh + " 얼음추가" + "가 주문목록에 추가되었습니다.");
										} else if (shotOp == 0 && iceOp == 1 && creamOp == 1) {
											System.out.println(menuCh + " 휘핑크림추가" + " 얼음추가" + "가 주문목록에 추가되었습니다.");
										} else if (shotOp > 0 && iceOp == 1 && creamOp == 1) {
											System.out.println(
													menuCh + " 샷 " + shotOp + " 휘핑크림추가" + " 얼음추가" + "가 주문목록에 추가되었습니다.");
										} else if (shotOp > 0 && iceOp == 0 && creamOp == 1) {
											System.out
													.println(menuCh + " 샷 " + shotOp + " 휘핑크림추가" + "가 주문목록에 추가되었습니다.");
										} else if (shotOp > 0 && iceOp == 1 && creamOp == 0) {
											System.out.println(menuCh + " 샷 " + shotOp + " 얼음추가" + "가 주문목록에 추가되었습니다.");
										}
									}
								}
							}
						}
					}
				} else if (kind == 2) {
					System.out.print(
							"\n4.복숭아 아이스티 3000원" + "\n\n주문할 메뉴를 선택해 주세요:" + "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");

					int order = scan.nextInt();
					if (order == 100) {
						continue;
					} else if (order == 101) {
						break;
					} else {
						if (order == 4) {
							menuCh = "복숭아 아이스티";
							orderPr = 3000;
							System.out.print("샷 추가를 몇 번 하시겠습니까? 샷당 +300원" + "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
							int shotOp = scan.nextInt();
							if (shotOp == 100) {
								continue;
							} else if (shotOp == 101) {
								break;
							} else {
								orderOp = 300 * shotOp;
								menusum3 = orderPr + orderOp;
								totalSum += menusum3;
								orderList[count] = menuCh;
								count++;
								if (shotOp == 0) {
									System.out.println(menuCh + "가 주문목록에 추가되었습니다.");
								} else if (shotOp > 0) {
									System.out.println(menuCh + " 샷 " + shotOp + "추가가 주문목록에 추가되었습니다.");
								}
							}

						}
					}
				} else if (kind == 3) {
					continue;
				} else if (kind == 4) {
					break;
				}
			} else if (menu == 2) {
				System.out.println("=================주문목록===================");

				for (int i = 0; i < count; i++) {
					System.out.println("[" + (i + 1) + "]" + orderList[i]);
				}
				System.out.println("\n취소할 메뉴 번호를 선택해 주세요"
						+ "\n처음 으로 되돌아가시려면 100을 종료 하시려면 101을 입력해주세요");
				int cancelMenu = scan.nextInt();
				if (cancelMenu == 100) {
					continue;
				} else if (cancelMenu == 101) {
					break;
				} else {
				String deleteMenu = orderList[cancelMenu - 1];

				if (cancelMenu >= 1 && cancelMenu <= count) {
					if (deleteMenu.equals("아메리카노")) {
						totalSum -= menusum;
					} else if (deleteMenu.equals("카페 라떼")) {
						totalSum -= menusum1;
					} else if (deleteMenu.equals("카페 모카")) {
						totalSum -= menusum2;
					} else if (deleteMenu.equals("복숭아 아이스티")) {
						totalSum -= menusum3;
					}
					count--;
				} else {
					System.out.println("잘못된 입력입니다");
				}

				for (int i = cancelMenu - 1; i < count; i++) {

					orderList[i] = orderList[i + 1];
				}
				System.out.println(deleteMenu + "가 주문목록에서 삭제되었습니다.");

				System.out.println();
				}

			} else if (menu == 3) {
				System.out.print("총 주문금액 : " + totalSum + "\n결제할 금액 : "
						+ "뒤로 가시려면 결제할 금액에 0을 넣어 주세요");

				int payment = scan.nextInt();
				
				if (payment == 100) {
					continue;
				} else if (payment == 101) {
					break;
				} else {

				if (payment >= totalSum) {

					System.out.println("결제가 완료되었습니다."

							+ "\n거스름돈은 " + (payment - totalSum) + "원 입니다.");

					totalSum = 0;

					for (int i = 0; i < count; i++) {
						orderList[i] = "";
					}

				} else {

					System.out.println("금액이 부족합니다.");
				}
				System.out.println();
				}

			} else if (menu == 4) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

}
