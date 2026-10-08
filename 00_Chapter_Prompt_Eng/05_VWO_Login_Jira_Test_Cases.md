# VWO Login Test Cases (Jira Ready)

## Issue Context

- **Project / component:** VWO / Authentication (map to the Jira project used by the team)
- **Feature:** Login, recovery, and authenticated access
- **Environment:** `https://app.wingify.com/#/login` (production URL supplied by requester)
- **Scope:** Login page and post-login redirect/access validation. Includes valid/invalid credentials, empty fields, form validation, forgot password, remember me, MFA/SSO when configured, and security/access control.
- **Source:** Attached VWO PRD and scope confirmed by requester. The requirement IDs below are local traceability IDs, not IDs claimed to be in the PRD.
- **Execution status:** All cases are **Not Run**. No browser execution is represented by this document.

## Local Requirement Traceability

| Requirement ID | Coverage intent |
| --- | --- |
| VWO-AUTH-01 | Valid users authenticate and reach their authorized destination. |
| VWO-AUTH-02 | Invalid or incomplete credentials do not establish an authenticated session. |
| VWO-AUTH-03 | Input validation and credential presentation follow approved security behavior. |
| VWO-AUTH-04 | Password recovery follows the approved recovery and account-enumeration policy. |
| VWO-AUTH-05 | Remember-me persistence follows the defined session policy. |
| VWO-AUTH-06 | Configured MFA and SSO gate access and complete the expected identity flow. |
| VWO-AUTH-07 | Protected routes, sessions, and roles enforce authentication and authorization. |
| VWO-AUTH-08 | Repeated failures follow the approved rate-limit/lockout policy. |

## Test Cases

Each case should be filed as a Jira Test/Task using its local test ID, requirement mapping, priority, preconditions, steps, and expected result. Capture Actual Result and Execution Status during execution; current values are **Not executed / Not Run**.

| Test ID | Summary | Requirement | Priority / Type | Preconditions and data | Steps | Expected result | Actual / Status |
| --- | --- | --- | --- | --- | --- | --- | --- |
| VWO-LOGIN-001 | Login with valid credentials and verify redirect | VWO-AUTH-01 | P0 / Functional, smoke | Active test account, known role and expected landing route; credentials from approved secret store. | 1. Open login. 2. Enter valid credentials. 3. Submit. 4. Wait for authenticated state. 5. Record destination and open an authorized protected route. | Authentication succeeds, expected landing route is reached, and authorized content is accessible. Credentials do not appear in the URL. | Not executed / Not Run |
| VWO-LOGIN-002 | Reject invalid password | VWO-AUTH-02 | P0 / Negative | Active test username and approved wrong password. | 1. Open login. 2. Enter valid username and wrong password. 3. Submit. 4. Attempt a protected route. | Authentication is denied, user remains unauthenticated, protected content is unavailable, and product-appropriate error feedback is shown. Exact copy requires confirmation. | Not executed / Not Run |
| VWO-LOGIN-003 | Reject unknown username | VWO-AUTH-02 | P0 / Negative, security | Synthetic username confirmed not to belong to a real user; non-secret invalid password. | 1. Open login. 2. Enter synthetic username and password. 3. Submit. 4. Attempt a protected route. | Authentication is denied and no session is established. Error behavior follows the approved account-enumeration policy. | Not executed / Not Run |
| VWO-LOGIN-004 | Submit with both fields empty | VWO-AUTH-02, VWO-AUTH-03 | P0 / Validation | Login form loaded. | 1. Leave username and password empty. 2. Submit. 3. Observe validation and resulting auth state. | Submission is blocked or rejected with required-field feedback; no authenticated state is created. Confirm exact validation behavior. | Not executed / Not Run |
| VWO-LOGIN-005 | Submit with empty password | VWO-AUTH-02, VWO-AUTH-03 | P1 / Validation | Login form loaded; approved test username. | 1. Enter username. 2. Leave password empty. 3. Submit. | Submission is blocked or rejected with password validation; no authenticated state is created. | Not executed / Not Run |
| VWO-LOGIN-006 | Submit with empty username | VWO-AUTH-02, VWO-AUTH-03 | P1 / Validation | Login form loaded; use a non-secret invalid password. | 1. Leave username empty. 2. Enter password. 3. Submit. | Submission is blocked or rejected with username validation; no authenticated state is created. | Not executed / Not Run |
| VWO-LOGIN-007 | Validate malformed username/email | VWO-AUTH-03 | P1 / Boundary, validation | Confirm whether the account identifier must be an email; use synthetic malformed value and invalid password. | 1. Enter malformed value. 2. Enter password. 3. Submit. 4. Observe validation and auth state. | Input follows documented format rules; no authenticated session is created. If identifiers need not be email-formatted, replace with agreed boundary cases. | Not executed / Not Run |
| VWO-LOGIN-008 | Open and complete forgot-password flow | VWO-AUTH-04 | P1 / Functional | Recovery enabled; controlled test account and mailbox available. | 1. Activate forgot-password link. 2. Enter test account identifier. 3. Submit. 4. Inspect confirmation and controlled mailbox. | Recovery flow is reachable and produces approved confirmation. Account existence is not disclosed contrary to policy. Confirm delivery timing separately if required. | Not executed / Not Run |
| VWO-LOGIN-009 | Remember-me enabled persistence | VWO-AUTH-05 | P1 / Session | Remember-me option and persistence policy confirmed; controlled browser profile. | 1. Enable remember me. 2. Log in. 3. Close/reopen browser as specified. 4. Revisit protected route. | Persistence matches documented policy without exposing credentials or bypassing session restrictions. | Not executed / Not Run |
| VWO-LOGIN-010 | Remember-me disabled persistence | VWO-AUTH-05 | P1 / Session | Default session policy confirmed; clean browser profile. | 1. Leave remember me disabled. 2. Log in. 3. End browser session as specified. 4. Revisit protected route. | Behavior matches the documented non-remembered session policy; unauthenticated access is redirected or denied. | Not executed / Not Run |
| VWO-LOGIN-011 | Complete MFA when required | VWO-AUTH-06 | P0 / Functional, security | MFA enabled for test account in approved test tenant; controlled factor available. | 1. Submit valid primary credentials. 2. Verify MFA challenge. 3. Submit valid factor. 4. Verify destination and role access. | Access is granted only after successful MFA and reaches the authorized destination. | Not executed / Not Run |
| VWO-LOGIN-012 | Reject missing, invalid, or expired MFA factor | VWO-AUTH-06 | P0 / Negative, security | MFA enabled in approved test environment; approved invalid/expired factor data. | 1. Submit valid primary credentials. 2. Omit or submit invalid/expired factor. 3. Try protected route. | Authentication does not complete and protected content remains inaccessible; feedback follows configured MFA policy. | Not executed / Not Run |
| VWO-LOGIN-013 | Complete configured SSO flow | VWO-AUTH-06 | P1 / Integration | SSO configured in test tenant; approved IdP account and test IdP available. | 1. Select configured SSO option. 2. Authenticate with test IdP. 3. Complete any required MFA. 4. Verify destination and authorized access. | IdP flow completes and grants only the access associated with the mapped user/role. | Not executed / Not Run |
| VWO-LOGIN-014 | Deny authenticated user access to unauthorized resource | VWO-AUTH-01, VWO-AUTH-07 | P0 / Authorization | Restricted-role account and approved access matrix/route. | 1. Authenticate as restricted user. 2. Open disallowed route directly. 3. Attempt restricted action. | Authentication may succeed, but unauthorized resource/action is denied according to the role/access matrix. | Not executed / Not Run |
| VWO-LOGIN-015 | Deny direct protected-route access without session | VWO-AUTH-07 | P0 / Access control | Clean unauthenticated browser; known protected route. | 1. Open protected route directly. 2. Inspect final route and content. | Protected content is not exposed; user is redirected to login or shown the approved denial state. Return-to-route behavior follows product policy. | Not executed / Not Run |
| VWO-LOGIN-016 | Logout invalidates session and protected access | VWO-AUTH-07 | P0 / Session, access control | Authenticated test account and protected route. | 1. Log in. 2. Log out. 3. Open protected route directly. 4. Try back/refresh where applicable. | Session is invalidated; protected data is not served after logout and re-authentication is required. | Not executed / Not Run |
| VWO-LOGIN-017 | Expired session cannot access protected content | VWO-AUTH-07 | P1 / Session, access control | Timeout duration known; approved test environment and test account. | 1. Log in. 2. Allow configured timeout or use approved test configuration. 3. Request protected route/action. | Expired session is rejected and protected data is inaccessible; re-authentication follows the product flow. | Not executed / Not Run |
| VWO-LOGIN-018 | Repeated failures follow rate-limit/lockout policy | VWO-AUTH-08 | P1 / Security | Non-production environment, disposable account, documented threshold/recovery policy. | 1. Submit invalid credentials only up to approved threshold. 2. Observe throttle/challenge/lockout. 3. Verify recovery behavior. | Configured security control is applied. Do not probe thresholds or risk locking users in production. | Not executed / Not Run |
| VWO-LOGIN-019 | Password masking and no credential leakage in URL | VWO-AUTH-03 | P1 / Security, UI | Login form loaded; synthetic non-secret string only. | 1. Enter string in password field. 2. Inspect display. 3. Submit failed attempt. 4. Inspect URL and visible error output. | Password is masked by default; credentials are not placed in the URL or echoed in visible error output. | Not executed / Not Run |

## Priority and Open Acceptance Criteria

- **P0:** Critical authentication, authorization, redirect, or access-control coverage.
- **P1:** Important validation, recovery, session, and security coverage.
- Confirm exact field rules/error copy, expected post-login route, password recovery behavior, remember-me semantics, MFA/SSO configuration, role/access matrix, session timeout, and lockout/rate-limit policy before final execution.
- Production URL is suitable only for approved, low-impact smoke checks. Run lockout, MFA-negative, and other state-changing security cases in an approved test tenant.
- Use synthetic or approved accounts. Never place credentials in Jira, screenshots, logs, or source control.
