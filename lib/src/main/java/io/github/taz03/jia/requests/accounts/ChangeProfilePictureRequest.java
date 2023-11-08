package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram change profile picture request, used to change profile.
 * <p>
 * To get the upload id, you will have to first upload a photo using {@link io.github.taz03.jia.requests.rupload.RuploadIgphotoRequest}
 * {@snippet lang=java :
 * RuploadIgphotoRequest photoUploadRequest = new RuploadIgphotoRequest(Path.of("/path/to/photo.png"));
 * RuploadIgphotoResponse photoUploadResponse = client.sendRequest(photoUploadRequest).get();
 *
 * ChangeProfilePictureRequest changeProfileRequest = new ChangeProfilePictureRequest(photoUploadResponse.getUploadId());
 * }
 */
public final class ChangeProfilePictureRequest extends InstagramPostRequest<UserResponse> {
    /**
     * Creates an Instagram change profile picture request.
	 *
	 * @param uploadId upload id of image to set as profile
     */
	public ChangeProfilePictureRequest(String uploadId) {
		super(UserResponse.class, "/api/v1/accounts/change_profile_picture/", null, Map.of("upload_id", uploadId));
	}
}
