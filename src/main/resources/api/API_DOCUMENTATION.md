# API Documentation

## Auth

[회원가입 (POST /api/auth/register)](auth/register.md)  
[토큰 갱신 (POST /api/auth/refresh)](auth/refresh.md)

## Profile

[닉네임 추천 (POST /api/profiles/nickname)](profile/suggest_nickname.md)  
[프로필 생성 (POST /api/profiles)](profile/create_profile.md)  
[나의 프로필 조회 (GET /api/profiles/uuid)](profile/get_profile_uuid.md)  
[전체 프로필 개수 조회 (GET /api/profiles/count)](profile/count_profile.md)  
[성별 프로필 개수 조회 (GET /api/profiles/genders/{gender}/count)](profile/count_profile_by_gender.md)  
[구매한 프로필 아이디 조회 (GET /api/profiles/{profileId})](profile/get_profile_id.md)  
[랜덤 프로필 조회 (GET /api/profiles/random)](profile/get_random_profile.md)  
[연락처 구매 (POST /api/profiles/ticket)](profile/consume_ticket.md)

[블랙리스트 추가 (POST /api/profiles/blacklists)](profile/add_blacklist.md)  
[블랙리스트 삭제 (DELETE /api/profiles/blacklists)](profile/delete_blacklist.md)  

## Viewer

[인증번호 발급 (POST /api/viewers/verification)](viewer/issue_verification.md)  
[티켓 발급 확인 (GET /api/viewers/tickets/events)](viewer/subscribe_ticket_events.md)  
[뷰어 조회 (GET /api/viewers/uuid)](viewer/get_viewer_uuid.md)

## Admin

[개발용 토큰 발급 (POST /api/auth/dev/token)](auth/dev-token.md)  
[전체 프로필 조회 (GET /api/profiles)](profile/get_all_profile_for_admin.md)  
[전체 뷰어 조회 (GET /api/viewers)](viewer/get_all_viewer_for_admin.md)  
[티켓 발급 (POST /api/viewers)](viewer/issue_ticket.md)  
[은행 입금 문자 티켓 발급 (POST /api/viewers/sms)](viewer/issue_ticket_by_bank_deposit_sms.md)  
[은행 입금 확인 요청(POST /api/viewers/notification)](viewer/issue_ticket_by_deposit_name.md)
