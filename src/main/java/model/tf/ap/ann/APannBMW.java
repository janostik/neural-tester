package model.tf.ap.ann;

import org.apache.commons.math3.stat.descriptive.summary.Sum;

/**
 * 
 * @author adam
 */
public class APannBMW extends APtfann {

    double[][] points = new double[][]{{0.38518,0.343531,0.302461,0.310499,0.332713,0.368264,0.357747,0.363426,0.382101,0.359786,0.402475},{0.343531,0.302461,0.310499,0.332713,0.368264,0.357747,0.363426,0.382101,0.359786,0.402475,0.451243},{0.302461,0.310499,0.332713,0.368264,0.357747,0.363426,0.382101,0.359786,0.402475,0.451243,0.449223},{0.310499,0.332713,0.368264,0.357747,0.363426,0.382101,0.359786,0.402475,0.451243,0.449223,0.46062},{0.332713,0.368264,0.357747,0.363426,0.382101,0.359786,0.402475,0.451243,0.449223,0.46062,0.475456},{0.368264,0.357747,0.363426,0.382101,0.359786,0.402475,0.451243,0.449223,0.46062,0.475456,0.53944},{0.357747,0.363426,0.382101,0.359786,0.402475,0.451243,0.449223,0.46062,0.475456,0.53944,0.6173},{0.363426,0.382101,0.359786,0.402475,0.451243,0.449223,0.46062,0.475456,0.53944,0.6173,0.685542},{0.382101,0.359786,0.402475,0.451243,0.449223,0.46062,0.475456,0.53944,0.6173,0.685542,0.607962},{0.359786,0.402475,0.451243,0.449223,0.46062,0.475456,0.53944,0.6173,0.685542,0.607962,0.624738},{0.402475,0.451243,0.449223,0.46062,0.475456,0.53944,0.6173,0.685542,0.607962,0.624738,0.631256},{0.451243,0.449223,0.46062,0.475456,0.53944,0.6173,0.685542,0.607962,0.624738,0.631256,0.637834},{0.449223,0.46062,0.475456,0.53944,0.6173,0.685542,0.607962,0.624738,0.631256,0.637834,0.648111},{0.46062,0.475456,0.53944,0.6173,0.685542,0.607962,0.624738,0.631256,0.637834,0.648111,0.699518},{0.475456,0.53944,0.6173,0.685542,0.607962,0.624738,0.631256,0.637834,0.648111,0.699518,0.69208},{0.53944,0.6173,0.685542,0.607962,0.624738,0.631256,0.637834,0.648111,0.699518,0.69208,0.69276},{0.6173,0.685542,0.607962,0.624738,0.631256,0.637834,0.648111,0.699518,0.69208,0.69276,0.680763},{0.685542,0.607962,0.624738,0.631256,0.637834,0.648111,0.699518,0.69208,0.69276,0.680763,0.620959},{0.607962,0.624738,0.631256,0.637834,0.648111,0.699518,0.69208,0.69276,0.680763,0.620959,0.662148},{0.624738,0.631256,0.637834,0.648111,0.699518,0.69208,0.69276,0.680763,0.620959,0.662148,0.642493},{0.631256,0.637834,0.648111,0.699518,0.69208,0.69276,0.680763,0.620959,0.662148,0.642493,0.69196},{0.637834,0.648111,0.699518,0.69208,0.69276,0.680763,0.620959,0.662148,0.642493,0.69196,0.708596},{0.648111,0.699518,0.69208,0.69276,0.680763,0.620959,0.662148,0.642493,0.69196,0.708596,0.69296},{0.699518,0.69208,0.69276,0.680763,0.620959,0.662148,0.642493,0.69196,0.708596,0.69296,0.6928},{0.69208,0.69276,0.680763,0.620959,0.662148,0.642493,0.69196,0.708596,0.69296,0.6928,0.734329},{0.69276,0.680763,0.620959,0.662148,0.642493,0.69196,0.708596,0.69296,0.6928,0.734329,0.739348},{0.680763,0.620959,0.662148,0.642493,0.69196,0.708596,0.69296,0.6928,0.734329,0.739348,0.794973},{0.620959,0.662148,0.642493,0.69196,0.708596,0.69296,0.6928,0.734329,0.739348,0.794973,0.789375},{0.662148,0.642493,0.69196,0.708596,0.69296,0.6928,0.734329,0.739348,0.794973,0.789375,0.774659},{0.642493,0.69196,0.708596,0.69296,0.6928,0.734329,0.739348,0.794973,0.789375,0.774659,0.752144},{0.69196,0.708596,0.69296,0.6928,0.734329,0.739348,0.794973,0.789375,0.774659,0.752144,0.791394},{0.708596,0.69296,0.6928,0.734329,0.739348,0.794973,0.789375,0.774659,0.752144,0.791394,0.810549},{0.69296,0.6928,0.734329,0.739348,0.794973,0.789375,0.774659,0.752144,0.791394,0.810549,0.832004},{0.6928,0.734329,0.739348,0.794973,0.789375,0.774659,0.752144,0.791394,0.810549,0.832004,0.783456},{0.734329,0.739348,0.794973,0.789375,0.774659,0.752144,0.791394,0.810549,0.832004,0.783456,0.815188},{0.739348,0.794973,0.789375,0.774659,0.752144,0.791394,0.810549,0.832004,0.783456,0.815188,0.837182},{0.794973,0.789375,0.774659,0.752144,0.791394,0.810549,0.832004,0.783456,0.815188,0.837182,0.853418},{0.789375,0.774659,0.752144,0.791394,0.810549,0.832004,0.783456,0.815188,0.837182,0.853418,0.844181},{0.774659,0.752144,0.791394,0.810549,0.832004,0.783456,0.815188,0.837182,0.853418,0.844181,0.826045},{0.752144,0.791394,0.810549,0.832004,0.783456,0.815188,0.837182,0.853418,0.844181,0.826045,0.929538},{0.791394,0.810549,0.832004,0.783456,0.815188,0.837182,0.853418,0.844181,0.826045,0.929538,0.916942},{0.810549,0.832004,0.783456,0.815188,0.837182,0.853418,0.844181,0.826045,0.929538,0.916942,0.944015},{0.832004,0.783456,0.815188,0.837182,0.853418,0.844181,0.826045,0.929538,0.916942,0.944015,1.},{0.783456,0.815188,0.837182,0.853418,0.844181,0.826045,0.929538,0.916942,0.944015,1.,0.968308},{0.815188,0.837182,0.853418,0.844181,0.826045,0.929538,0.916942,0.944015,1.,0.968308,0.874933},{0.837182,0.853418,0.844181,0.826045,0.929538,0.916942,0.944015,1.,0.968308,0.874933,0.878592},{0.853418,0.844181,0.826045,0.929538,0.916942,0.944015,1.,0.968308,0.874933,0.878592,0.88511},{0.844181,0.826045,0.929538,0.916942,0.944015,1.,0.968308,0.874933,0.878592,0.88511,0.831624},{0.826045,0.929538,0.916942,0.944015,1.,0.968308,0.874933,0.878592,0.88511,0.831624,0.843181},{0.929538,0.916942,0.944015,1.,0.968308,0.874933,0.878592,0.88511,0.831624,0.843181,0.836702},{0.916942,0.944015,1.,0.968308,0.874933,0.878592,0.88511,0.831624,0.843181,0.836702,0.877812},{0.944015,1.,0.968308,0.874933,0.878592,0.88511,0.831624,0.843181,0.836702,0.877812,0.872593},{1.,0.968308,0.874933,0.878592,0.88511,0.831624,0.843181,0.836702,0.877812,0.872593,0.890708},{0.968308,0.874933,0.878592,0.88511,0.831624,0.843181,0.836702,0.877812,0.872593,0.890708,0.875872},{0.874933,0.878592,0.88511,0.831624,0.843181,0.836702,0.877812,0.872593,0.890708,0.875872,0.865035},{0.878592,0.88511,0.831624,0.843181,0.836702,0.877812,0.872593,0.890708,0.875872,0.865035,0.854598},{0.88511,0.831624,0.843181,0.836702,0.877812,0.872593,0.890708,0.875872,0.865035,0.854598,0.854598},{0.831624,0.843181,0.836702,0.877812,0.872593,0.890708,0.875872,0.865035,0.854598,0.854598,0.854598},{0.843181,0.836702,0.877812,0.872593,0.890708,0.875872,0.865035,0.854598,0.854598,0.854598,0.850679},{0.836702,0.877812,0.872593,0.890708,0.875872,0.865035,0.854598,0.854598,0.854598,0.850679,0.816828},{0.877812,0.872593,0.890708,0.875872,0.865035,0.854598,0.854598,0.854598,0.850679,0.816828,0.870294},{0.872593,0.890708,0.875872,0.865035,0.854598,0.854598,0.854598,0.850679,0.816828,0.870294,0.897347},{0.890708,0.875872,0.865035,0.854598,0.854598,0.854598,0.850679,0.816828,0.870294,0.897347,0.872893},{0.875872,0.865035,0.854598,0.854598,0.854598,0.850679,0.816828,0.870294,0.897347,0.872893,0.854038},{0.865035,0.854598,0.854598,0.854598,0.850679,0.816828,0.870294,0.897347,0.872893,0.854038,0.858677},{0.854598,0.854598,0.854598,0.850679,0.816828,0.870294,0.897347,0.872893,0.854038,0.858677,0.810869},{0.854598,0.854598,0.850679,0.816828,0.870294,0.897347,0.872893,0.854038,0.858677,0.810869,0.762642},{0.854598,0.850679,0.816828,0.870294,0.897347,0.872893,0.854038,0.858677,0.810869,0.762642,0.790235},{0.850679,0.816828,0.870294,0.897347,0.872893,0.854038,0.858677,0.810869,0.762642,0.790235,0.796853},{0.816828,0.870294,0.897347,0.872893,0.854038,0.858677,0.810869,0.762642,0.790235,0.796853,0.763202},{0.870294,0.897347,0.872893,0.854038,0.858677,0.810869,0.762642,0.790235,0.796853,0.763202,0.773439},{0.897347,0.872893,0.854038,0.858677,0.810869,0.762642,0.790235,0.796853,0.763202,0.773439,0.762642},{0.872893,0.854038,0.858677,0.810869,0.762642,0.790235,0.796853,0.763202,0.773439,0.762642,0.811289},{0.854038,0.858677,0.810869,0.762642,0.790235,0.796853,0.763202,0.773439,0.762642,0.811289,0.761222},{0.858677,0.810869,0.762642,0.790235,0.796853,0.763202,0.773439,0.762642,0.811289,0.761222,0.685222},{0.810869,0.762642,0.790235,0.796853,0.763202,0.773439,0.762642,0.811289,0.761222,0.685222,0.676824},{0.762642,0.790235,0.796853,0.763202,0.773439,0.762642,0.811289,0.761222,0.685222,0.676824,0.676824},{0.790235,0.796853,0.763202,0.773439,0.762642,0.811289,0.761222,0.685222,0.676824,0.676824,0.697679},{0.796853,0.763202,0.773439,0.762642,0.811289,0.761222,0.685222,0.676824,0.676824,0.697679,0.69288},{0.763202,0.773439,0.762642,0.811289,0.761222,0.685222,0.676824,0.676824,0.697679,0.69288,0.646332},{0.773439,0.762642,0.811289,0.761222,0.685222,0.676824,0.676824,0.697679,0.69288,0.646332,0.65415},{0.762642,0.811289,0.761222,0.685222,0.676824,0.676824,0.697679,0.69288,0.646332,0.65415,0.746766},{0.811289,0.761222,0.685222,0.676824,0.676824,0.697679,0.69288,0.646332,0.65415,0.746766,0.745446},{0.761222,0.685222,0.676824,0.676824,0.697679,0.69288,0.646332,0.65415,0.746766,0.745446,0.697179},{0.685222,0.676824,0.676824,0.697679,0.69288,0.646332,0.65415,0.746766,0.745446,0.697179,0.65409},{0.676824,0.676824,0.697679,0.69288,0.646332,0.65415,0.746766,0.745446,0.697179,0.65409,0.713554},{0.676824,0.697679,0.69288,0.646332,0.65415,0.746766,0.745446,0.697179,0.65409,0.713554,0.671965},{0.697679,0.69288,0.646332,0.65415,0.746766,0.745446,0.697179,0.65409,0.713554,0.671965,0.6912},{0.69288,0.646332,0.65415,0.746766,0.745446,0.697179,0.65409,0.713554,0.671965,0.6912,0.757923},{0.646332,0.65415,0.746766,0.745446,0.697179,0.65409,0.713554,0.671965,0.6912,0.757923,0.748865},{0.65415,0.746766,0.745446,0.697179,0.65409,0.713554,0.671965,0.6912,0.757923,0.748865,0.725291},{0.746766,0.745446,0.697179,0.65409,0.713554,0.671965,0.6912,0.757923,0.748865,0.725291,0.716094},{0.745446,0.697179,0.65409,0.713554,0.671965,0.6912,0.757923,0.748865,0.725291,0.716094,0.716094},{0.697179,0.65409,0.713554,0.671965,0.6912,0.757923,0.748865,0.725291,0.716094,0.716094,0.698798},{0.65409,0.713554,0.671965,0.6912,0.757923,0.748865,0.725291,0.716094,0.716094,0.698798,0.719353},{0.713554,0.671965,0.6912,0.757923,0.748865,0.725291,0.716094,0.716094,0.698798,0.719353,0.679623},{0.671965,0.6912,0.757923,0.748865,0.725291,0.716094,0.716094,0.698798,0.719353,0.679623,0.649571},{0.6912,0.757923,0.748865,0.725291,0.716094,0.716094,0.698798,0.719353,0.679623,0.649571,0.642153},{0.757923,0.748865,0.725291,0.716094,0.716094,0.698798,0.719353,0.679623,0.649571,0.642153,0.634275},{0.748865,0.725291,0.716094,0.716094,0.698798,0.719353,0.679623,0.649571,0.642153,0.634275,0.650231},{0.725291,0.716094,0.716094,0.698798,0.719353,0.679623,0.649571,0.642153,0.634275,0.650231,0.610801},{0.716094,0.716094,0.698798,0.719353,0.679623,0.649571,0.642153,0.634275,0.650231,0.610801,0.61524},{0.716094,0.698798,0.719353,0.679623,0.649571,0.642153,0.634275,0.650231,0.610801,0.61524,0.570832},{0.698798,0.719353,0.679623,0.649571,0.642153,0.634275,0.650231,0.610801,0.61524,0.570832,0.590287},{0.719353,0.679623,0.649571,0.642153,0.634275,0.650231,0.610801,0.61524,0.570832,0.590287,0.643413},{0.679623,0.649571,0.642153,0.634275,0.650231,0.610801,0.61524,0.570832,0.590287,0.643413,0.648211},{0.649571,0.642153,0.634275,0.650231,0.610801,0.61524,0.570832,0.590287,0.643413,0.648211,0.623938},{0.642153,0.634275,0.650231,0.610801,0.61524,0.570832,0.590287,0.643413,0.648211,0.623938,0.597805},{0.634275,0.650231,0.610801,0.61524,0.570832,0.590287,0.643413,0.648211,0.623938,0.597805,0.594745},{0.650231,0.610801,0.61524,0.570832,0.590287,0.643413,0.648211,0.623938,0.597805,0.594745,0.557895},{0.610801,0.61524,0.570832,0.590287,0.643413,0.648211,0.623938,0.597805,0.594745,0.557895,0.588927},{0.61524,0.570832,0.590287,0.643413,0.648211,0.623938,0.597805,0.594745,0.557895,0.588927,0.572551},{0.570832,0.590287,0.643413,0.648211,0.623938,0.597805,0.594745,0.557895,0.588927,0.572551,0.670426},{0.590287,0.643413,0.648211,0.623938,0.597805,0.594745,0.557895,0.588927,0.572551,0.670426,0.705816},{0.643413,0.648211,0.623938,0.597805,0.594745,0.557895,0.588927,0.572551,0.670426,0.705816,0.675184},{0.648211,0.623938,0.597805,0.594745,0.557895,0.588927,0.572551,0.670426,0.705816,0.675184,0.6911},{0.623938,0.597805,0.594745,0.557895,0.588927,0.572551,0.670426,0.705816,0.675184,0.6911,0.6918},{0.597805,0.594745,0.557895,0.588927,0.572551,0.670426,0.705816,0.675184,0.6911,0.6918,0.600684},{0.594745,0.557895,0.588927,0.572551,0.670426,0.705816,0.675184,0.6911,0.6918,0.600684,0.597605},{0.557895,0.588927,0.572551,0.670426,0.705816,0.675184,0.6911,0.6918,0.600684,0.597605,0.636834},{0.588927,0.572551,0.670426,0.705816,0.675184,0.6911,0.6918,0.600684,0.597605,0.636834,0.609542},{0.572551,0.670426,0.705816,0.675184,0.6911,0.6918,0.600684,0.597605,0.636834,0.609542,0.611761},{0.670426,0.705816,0.675184,0.6911,0.6918,0.600684,0.597605,0.636834,0.609542,0.611761,0.565193},{0.705816,0.675184,0.6911,0.6918,0.600684,0.597605,0.636834,0.609542,0.611761,0.565193,0.528163},{0.675184,0.6911,0.6918,0.600684,0.597605,0.636834,0.609542,0.611761,0.565193,0.528163,0.475056},{0.6911,0.6918,0.600684,0.597605,0.636834,0.609542,0.611761,0.565193,0.528163,0.475056,0.511847},{0.6918,0.600684,0.597605,0.636834,0.609542,0.611761,0.565193,0.528163,0.475056,0.511847,0.54032},{0.600684,0.597605,0.636834,0.609542,0.611761,0.565193,0.528163,0.475056,0.511847,0.54032,0.530562},{0.597605,0.636834,0.609542,0.611761,0.565193,0.528163,0.475056,0.511847,0.54032,0.530562,0.522124},{0.636834,0.609542,0.611761,0.565193,0.528163,0.475056,0.511847,0.54032,0.530562,0.522124,0.49927},{0.609542,0.611761,0.565193,0.528163,0.475056,0.511847,0.54032,0.530562,0.522124,0.49927,0.545758},{0.611761,0.565193,0.528163,0.475056,0.511847,0.54032,0.530562,0.522124,0.49927,0.545758,0.542679},{0.565193,0.528163,0.475056,0.511847,0.54032,0.530562,0.522124,0.49927,0.545758,0.542679,0.543239},{0.528163,0.475056,0.511847,0.54032,0.530562,0.522124,0.49927,0.545758,0.542679,0.543239,0.532022},{0.475056,0.511847,0.54032,0.530562,0.522124,0.49927,0.545758,0.542679,0.543239,0.532022,0.508128},{0.511847,0.54032,0.530562,0.522124,0.49927,0.545758,0.542679,0.543239,0.532022,0.508128,0.503169},{0.54032,0.530562,0.522124,0.49927,0.545758,0.542679,0.543239,0.532022,0.508128,0.503169,0.451063},{0.530562,0.522124,0.49927,0.545758,0.542679,0.543239,0.532022,0.508128,0.503169,0.451063,0.410993},{0.522124,0.49927,0.545758,0.542679,0.543239,0.532022,0.508128,0.503169,0.451063,0.410993,0.442405},{0.49927,0.545758,0.542679,0.543239,0.532022,0.508128,0.503169,0.451063,0.410993,0.442405,0.425709},{0.545758,0.542679,0.543239,0.532022,0.508128,0.503169,0.451063,0.410993,0.442405,0.425709,0.433027},{0.542679,0.543239,0.532022,0.508128,0.503169,0.451063,0.410993,0.442405,0.425709,0.433027,0.46066},{0.543239,0.532022,0.508128,0.503169,0.451063,0.410993,0.442405,0.425709,0.433027,0.46066,0.463839},{0.532022,0.508128,0.503169,0.451063,0.410993,0.442405,0.425709,0.433027,0.46066,0.463839,0.440685},{0.508128,0.503169,0.451063,0.410993,0.442405,0.425709,0.433027,0.46066,0.463839,0.440685,0.487133},{0.503169,0.451063,0.410993,0.442405,0.425709,0.433027,0.46066,0.463839,0.440685,0.487133,0.470298},{0.451063,0.410993,0.442405,0.425709,0.433027,0.46066,0.463839,0.440685,0.487133,0.470298,0.483174},{0.410993,0.442405,0.425709,0.433027,0.46066,0.463839,0.440685,0.487133,0.470298,0.483174,0.50097},{0.442405,0.425709,0.433027,0.46066,0.463839,0.440685,0.487133,0.470298,0.483174,0.50097,0.42457},{0.425709,0.433027,0.46066,0.463839,0.440685,0.487133,0.470298,0.483174,0.50097,0.42457,0.374223},{0.433027,0.46066,0.463839,0.440685,0.487133,0.470298,0.483174,0.50097,0.42457,0.374223,0.362406},{0.46066,0.463839,0.440685,0.487133,0.470298,0.483174,0.50097,0.42457,0.374223,0.362406,0.369324},{0.463839,0.440685,0.487133,0.470298,0.483174,0.50097,0.42457,0.374223,0.362406,0.369324,0.374703},{0.440685,0.487133,0.470298,0.483174,0.50097,0.42457,0.374223,0.362406,0.369324,0.374703,0.356227},{0.487133,0.470298,0.483174,0.50097,0.42457,0.374223,0.362406,0.369324,0.374703,0.356227,0.322556}};

    public Integer[] discretizeVector(double[] vector) {
        int dim = vector.length;
        Integer[] discrete = new Integer[dim];

        for (int i = 0; i < dim; i++) {

            
            discrete[i] = Float.valueOf(Math.round(vector[i])).intValue();
            
        }

        return discrete;
    }

    @Override
    protected double getDistance(double[] vector) {

        double sum = 0, a, b, length_add = 1;
        double[] distance_array = new double[points.length];
        Integer[] gfs_vector = ap.getGFScode(ap.discretizeVector(vector));
        
        for(int i = 0; i < gfs_vector.length; i++){
            if(gfs_vector[i] == -1){
                length_add = 1/(double) (gfs_vector.length - i);
                break;
            }
        }
        
        for (int i = 0; i < points.length; i++) {
            a = ap.dsh(vector, new double[]{points[i][0],points[i][1],points[i][2],points[i][3],points[i][4],points[i][5],points[i][6],points[i][7],points[i][8],points[i][9]});
            if(Double.isNaN(a) || Double.isInfinite(a)){
                return Double.MAX_VALUE;
            }
            b = points[i][10];

            distance_array[i] = Math.abs(a-b);
        }
        
        return (new Sum().evaluate(distance_array)) + length_add;
//        return (new Median().evaluate(distance_array)) + (new Mean().evaluate(distance_array));

    }

    @Override
    public String name() {
        return "AP_ann_BMW";
    }
    
    public static void main(String[] args) throws Exception {
    
        /**
         * Nastaveni pro vyreseni se sinem
         */
        double[] vector = new double[]{-99,-99,20,20,20,-99,-99,45,45,45,45,-99,45,45,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        APtfann tf = new APannProb1();
        
        System.out.println(tf.fitness(vector));
        System.out.println(tf.ap.equation);
        
    }
    
}